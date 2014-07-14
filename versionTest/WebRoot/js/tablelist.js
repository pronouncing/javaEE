$(function(){
	//$("form").eq(0).focus();
	$(document).focus();
	
	$("input:text,input:password,textarea,.newContIpt").focus(function(){$(this).css({"border":"1px solid #a5cf3d","background-color":"#FCFCE9"});});
    $("input:text,input:password,textarea,.newContIpt").blur(function(){$(this).css({"border":"1px solid #ccc","background-color":"#fff"});});
	$(".listTable tr").mouseover(function(){
		$(this).addClass("curTd");							  
	});
	$(".listTable tr").mouseout(function(){
		$(this).removeClass("curTd");							  
	});
});


//全选、全不选
function checkAll(ids,chkAll){
	 var obj = document.getElementsByName(ids);
	 var chk = document.getElementById(chkAll);
	 for(var i=0; i<obj.length;i++){
		 	 obj[i].checked = chk.checked;
		 }
	 }
	
function textChkAll(ids,flag,chkAll){
	var obj = document.getElementsByName(ids);
	var chk = document.getElementById(chkAll);
	var $flag = false;
	
	switch(flag){
		case "true":$flag = true;break;
		default : $flag = false;break;
		}
	
	for(var i=0; i<obj.length;i++){
		  obj[i].checked = $flag;
			chk.checked = $flag;
			}
		
	}

//反选
function opCheck(ids,chkAll){
	var obj = document.getElementsByName(ids);
	var chk = document.getElementById(chkAll);
	
	for(var i=0;i<obj.length;i++){
		obj[i].checked = !obj[i].checked;
		}
	
	for(var i=0;i<obj.length;i++){
		if(!obj[i].checked){
			chk.checked = false;
			break;
			}
		}
	}