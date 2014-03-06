<?php 
$comando=$_POST['comando']; 
$port = fopen('com6','w+'); 
sleep(1); 
switch ($comando){ 
//abre o portao 
case "0000": 
echo fgets($port); 
break; 
} 
sleep(1); 
fclose($port); 
?> 