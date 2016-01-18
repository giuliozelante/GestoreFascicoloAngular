<%@ taglib prefix="s" uri="/struts-tags"%>
<script type='text/javascript'>
//<![CDATA[
$(document).ready(function() {
  $("#apriFascicolo").click(function (event) {
        event.preventDefault();
        if(validate($("form"))){
        	otherParams();
	        $("div#loading").fadeIn(2000);
	        $.ajax({
	          url: '<s:url action="apriFascicolo"/>',
	          type: "POST",
	          data: $("form").serialize(),
	          success: onSuccess,
	          error: onError
	        });
        }
        return false;
  });
  $("#chiudiFascicolo").click(function (event) {
        event.preventDefault();
        if(validate($("form"))){
	        otherParams();
	        $("div#loading").fadeIn(2000);
	        $.ajax({
	          url: '<s:url action="chiudiFascicolo"/>',
	          type: "POST",
	          data: $("form").serialize(),
	          success: onSuccess,
	          error: onError
	        });
        }
        return false;
    });
  });
  //modifica per bug su valorizzazione dell input other-params
  function otherParams() {
    $("#other-params").val($("#other-params").val().replace("?", $("#admin_fascicolo_fascicoloId").val()).replace("?", $("#admin_fascicolo_callerId").val()));
  }
  function validate(form){
	  var valid = true;
	  $(form).find('input[type="text"]').each(function(){
		  $(this).next('label').remove();
		  var required = $(this).attr('required');
		  var minlength = $(this).attr('minlength');
		  if(typeof required !== typeof undefined && required !== false && $.trim($(this).val())==''){
				  $(this).after('<label id="'+$(this).attr('id')+'-error" class="error" for="'+$(this).attr('id')+'">  Campo obbligatorio</label>')
/* 				  $(this).keyup(function(){
					  valid = validate(form);
				  }); */
				  valid = false;


		  }else if(typeof minlength !== typeof undefined && minlength !== false && $.trim($(this).val()).length<$(this).attr('minlength')){
				  $(this).after('<label id="'+$(this).attr('id')+'-error" class="error" for="'+$(this).attr('id')+'">  Inserisci almeno '+$(this).attr('minlength')+' caratteri</label>')
/* 				  $(this).keyup(function(){
				     valid = validate(form);
				   }); */
				  valid = false;
		  }
	  });
	  return valid;
  }
//]]>
</script>