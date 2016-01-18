package it.equitalia.gestorefascicolo.web.sevlet;

import it.equitalia.gestorefascicolo.web.util.EntityItemUtils;
import it.equitalia.gestorefascicolo.web.util.Log4jFactory;
import it.equitalia.gestorefascicolows.dati.EntityItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * mod 2015-03-12
 *
 */
public class FascicoloServlet extends HttpServlet {
	private static final long serialVersionUID = -1551073668572652371L;
	private static final Logger logger = Log4jFactory.getLogger(FascicoloServlet.class);
	private static final Logger errorLogger = Log4jFactory.getErrorLogger();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().println("prova ciccio");
		EntityItem cartella = (EntityItem) request.getSession().getAttribute("cartellaSession" );
		ArrayList<EntityItem> listaEntityItem;

		try {
			String parentEntityItemId = request.getParameter("parentEntityItemId");

			List<Integer> distinctEntityIdsEntityItemChils = EntityItemUtils.getDistinctEntityIdsEntityItemChils(cartella, Integer.parseInt(parentEntityItemId) );

			for (Integer entityId : distinctEntityIdsEntityItemChils) {

				listaEntityItem = EntityItemUtils.getChilds(cartella, Integer.parseInt(parentEntityItemId), entityId );

				 request.setAttribute("listaEntityItem", listaEntityItem);
				 request.setAttribute("parentEntityItemId", parentEntityItemId);
				 request.setAttribute("entityId", entityId);

			     ServletContext context = getServletContext();
			     RequestDispatcher dispatcher = context.getRequestDispatcher("/pages/anagraficaFascicolo/dettaglioCartella/detailEntityItemTabella.jsp");
			     dispatcher.include(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			errorLogger.error(e.getMessage(),e);
			//FIXME gestire un display di errore
		}

	}


}
