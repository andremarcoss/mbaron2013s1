<?php 
$comando=$_POST['comando']; 
$port = fopen('com6','w+'); 
sleep(1); 
switch ($comando){ 
case "5": 
fwrite($port, '0'); 
break; 
case "10": 
fwrite($port, '1'); 
break; 
case "15": 
fwrite($port, '2'); 
break; 
case "20": 
fwrite($port, '3'); 
break; 
case "25": 
fwrite($port, '4'); 
break; 
case "30": 
fwrite($port, '5'); 
break; 
case "35": 
fwrite($port, '6'); 
break; 
case "40": 
fwrite($port, '7'); 
break; 
case "45": 
fwrite($port, '8'); 
break; 
case "50": 
fwrite($port, '9'); 
break; 
case "666": 
fwrite($port, '*'); 
break; 
} 
sleep(2); 
fclose($port); 
?> 