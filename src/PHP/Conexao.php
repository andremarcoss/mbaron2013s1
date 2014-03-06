<?php 
$usuario=$_POST['login']; 
$senha=$_POST['senha']; 
$conexao=mysql_connect("localhost","root","");
mysql_select_db('home',$conexao); 
$sql="select * from usuario where nome='$usuario' and senha='$senha'"; 
$resultado=mysql_query($sql) or die ("Erro .:".mysql_error()); 
if(mysql_num_rows($resultado)>0) 
echo "1"; 
else 
echo "0"; 
?> 