#define ANALOG_PIN 0 
int Pin2 = 2; 
int Pin3 = 3; 
int Pin4 = 4; 
int Pin5 = 5; 
int Pin6 = 6; 
int Ventrada = 0 ; 
float Temperatura = 0; 
int x; 
void setup() { 
Serial.begin(9600); 
pinMode(Pin2, OUTPUT); 
pinMode(Pin3, OUTPUT); 
pinMode(Pin4, OUTPUT); 
pinMode(Pin5, OUTPUT); 
pinMode(Pin6, OUTPUT); 
} 
/****************************************************************/ 
/* Função para leitura de Temperatura  */ 
/****************************************************************/ 
int temp(){ 
Ventrada = analogRead (ANALOG_PIN); 
Temperatura=(500*Ventrada)/1023; 
if((Temperatura>=0)&&(Temperatura<=50)){ 
return Temperatura; 
} 
} 
/****************************************************************/ 
/* Inicio Programa Principal  */ 
/****************************************************************/ 
void loop(){ 
char caracter; 
caracter = Serial.read(); 
//se pressionado "v" liga a luz 
if(caracter == 'v') 
{ 
digitalWrite(Pin2, HIGH); 
} 
//se pressionado "a" desliga a luz 
else if(caracter == 'a') 
{ 
digitalWrite(Pin2, LOW); 
} 
else 
//Se pressionado "z" fecha o portao 
if(caracter == 'z') 
{ 
digitalWrite(Pin3, HIGH); 
} 
else 
//Se pressionado "l" abre o portao 
if(caracter == 'l') 
{ 
digitalWrite(Pin4, HIGH); 
} 
else{ 
digitalWrite(Pin3, LOW); 
digitalWrite(Pin4, LOW); 
} 
/*****************************************************/ 
/* controle temperatura  */ 
/*****************************************************/ 
if(caracter =='0'){ 
if(temp()>5){ 
digitalWrite(Pin6, HIGH); 
x = 5; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 5; 
} 
}else 
if(caracter =='1'){ 
if(temp()>10){ 
digitalWrite(Pin6, HIGH); 
x = 10; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 10; 
} 
}else 
if(caracter =='2'){ 
if(temp()>15){ 
digitalWrite(Pin6, HIGH); 
x = 15; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 15; 
} 
}else 
if(caracter =='3'){ 
if(temp()>20){ 
digitalWrite(Pin6, HIGH); 
x = 20; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 20; 
} 
}else 
if(caracter =='4'){ 
if(temp()>25){ 
digitalWrite(Pin6, HIGH); 
x = 25; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 25; 
} 
}else 
if(caracter =='5'){ 
if(temp()>30){ 
digitalWrite(Pin6, HIGH); 
x = 30; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 30; 
} 
}else 
if(caracter =='6'){ 
if(temp()>35){ 
digitalWrite(Pin6, HIGH); 
x = 35; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 35; 
} 
}else 
if(caracter =='7'){ 
if(temp()>40){ 
digitalWrite(Pin6, HIGH); 
x = 40; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 40; 
} 
}else 
if(caracter =='8'){ 
if(temp()>45){ 
digitalWrite(Pin6, HIGH); 
x = 45; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 45; 
} 
}else 
if(caracter =='9'){ 
if(temp()>50){ 
digitalWrite(Pin6, HIGH); 
x = 50; 
}else{ 
digitalWrite(Pin5, HIGH); 
x = 50; 
} 
}else 
if (caracter =='*') { 
digitalWrite(Pin6, LOW); 
digitalWrite(Pin5, LOW); 
} 
/*********************Fim do bloco Principal********************/ 
/**********************IF de controle de Temperatura************/ 
if(temp()==x){ 
digitalWrite(Pin5, LOW); 
digitalWrite(Pin6, LOW); 
x=0; 
} 
if((temp()>=0) && (temp()<=51)){ 
Serial.println(temp()); 
} 
delay(1000); 
} 
/**********************Fim do Programa************/
