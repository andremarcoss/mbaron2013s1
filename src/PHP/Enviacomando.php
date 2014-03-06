<?php 
$comando=$_POST['comando']; 
$port = fopen('com6','w+'); 
sleep(1); 
switch ($comando){ 
//abre o portao 
case "1001": 
fwrite($port, 'l'); 
break; 
//fecha o portao 
case "1011": 
fwrite($port, 'z'); 
break; 
//liga luz 
case "1111": 
fwrite($port, 'v'); 
break; 
//apaga a luz 
case "1110": 
fwrite($port, 'a'); 
break; 
} sleep(2); 
fclose($port); 
?> 