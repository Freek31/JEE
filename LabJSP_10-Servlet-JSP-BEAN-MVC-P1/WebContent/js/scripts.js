function Verifier(FormName)
{
	// Valeur du prénom saisi
	var vfirstname = FormName.firstName.value;
	// Valeur du nom saisi
	var vlastname = FormName.lastName.value;
	
	// Il doit avoir que des lettres
	// Il doit avoir au moins un caractère
	var exp=new RegExp("^[a-zA-Z]{1,}$","g");
  	if (!exp.test(vfirstname))
  	{
  		// Placer le focus dans la zone de l'identifiant
  		FormName.firstName.focus();
  		alert(" E R R E U R !\n\nLe prénom ["+vfirstname+"] n'est pas valide !!!!");
  		return false;
  	}
  	
  	// Il doit avoir que des lettres
	// Il doit avoir au moins un caractère
	var exp=new RegExp("^[a-zA-Z]{1,}$","g");
  	if (!exp.test(vlastname))
  	{
  		// Placer le focus dans la zone de l'identifiant
  		FormName.lastName.focus();
  		alert(" E R R E U R !\n\nLe prénom ["+vfirstname+"] n'est pas valide !!!!");
  		return false;
  	}
	
	alert(" T O U T est OK !!");
	// FormName.action = "";
	FormName.submit();
			
	return true;	
}