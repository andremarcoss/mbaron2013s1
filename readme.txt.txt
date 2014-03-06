RESUMO
Este trabalho tem o objetivo de desenvolver um sistema de controle projetado para
atender, de forma pr�tica, um crescente mercado de consumo voltado a tend�ncia
do uso de dispositivos m�veis, por causa da sua praticidade e facilidade de uso.
Como atividade pr�tica ser� desenvolvido um aplicativo m�vel baseado na
plataforma Android. Com essa aplica��o pode-se acessar de modo simples o
Arduino, que atrav�s do Android ser� poss�vel controlar dispositivos eletroeletr�nicos
como port�es, luzes e a temperatura ambiente e fazer a intera��o do
usu�rio com a sua resid�ncia.

Para a atividade pr�tica ser� criado um prot�tipo mec�nico representando a
resid�ncia com sua entrada e instala��es el�tricas e desenvolvido um aplicativo de
ativa��o por smartphones.
� Cria��o de um aplicativo Android para uso do celular ou smartphone, e
uso de um emulador para os testes.
� Cria��o de scripts em PHP para a conex�o do Arduino com o servidor
Web � comunica��o do servidor com o dispositivo Android.
� Cria��o dos layouts em XML para Android.
� Cria��o de um servidor de banco de dados e um servidor PHP para ser
usado como uma ponte entre a aplica��o Android e o prot�tipo.
� Para cria��o do firmware do micro controlador ser� utilizado o ambiente
de desenvolvimento para Arduino (Arduino 1.0.3).

Para o desenvolvimento desta aplica��o foi necess�rio o aprendizado tanto de uma
linguagem de programa��o como a do Arduino e o desenvolvimento do hardware.
Para a conclus�o foi adquirido novos conhecimentos em todas as etapas. Como o
desenvolvimento Java, que para ser desenvolvido para Android � um pouco
diferente da convencional, na cria��o do firmware, e na integra��o do software
com o hardware. Quanto a quest�o de conex�o com um banco de dados, o
desenvolvimento PHP com MYSQL e servidores web, seguran�a dos dados entre
outras. Tudo isso resultou em uma aplica��o que tamb�m � uma pequena vis�o
para um lado que n�o envolve a inform�tica que � a intera��o das pessoas com
suas tarefas di�rias. Todo este conhecimento necess�rio permitiu a realiza��o de
um trabalho bastante satisfat�rio tanto no ponto de vista t�cnico quanto
motivacional.


MANUAL DE OPERA��O E IMPLANTA��O
Para a implanta��o deste sistema ser� necess�rio o uso de quatro componentes
principais s�o eles;
� Um desktop que ser� usado como servidor web � de dados;
� Um celular ou smartphones com sistema Android;
� Uma placa Arduino Uno ou similar.
� Uma placa de rel�s para controlar os dispositivos externos.
A figura 13 ilustra o funcionamento de todo o sistema.
Figura 13: Topologia do Funcionamento do Sistema de Automa��o
Aparelho celular ou smartphones
O aparelho deve suportar o sistema Android, e a instala��o do aplicativo ser� feita via
Bluetooth usando o servidor para esta tarefa.
24
Servidor Web
Para a o servidor ser� usado o Xampp, pois ele � um pacote para ser usado como servidor
Web contendo o Apache, Mysql � o PHP.
Para a configura��o do PHP no Windows XP ser� necess�ria a altera��o do arquivo
php.ini-dist :
Copie o arquivo php.ini-dist, que se encontra na pasta c:\php, para a pasta do
Windows (geralmente c:\Windows). Troque seu nome por php.ini e em seguida
abra-o. Localize o seguinte texto dentro deste arquivo: "extension_dir" e altere o
valor desta entrada para o nome da pasta com os arquivos das extens�es do PHP,
que no nosso caso � "c:\php\extensions". Salve e feche este arquivo, copie
tamb�m o arquivo php4ts.dll, que se encontra na pasta c:\php, para a
pasta c:\Windows\System, no caso de Windows95/98/ME/XP, ou para a
pasta c:\WINNT\System32, no caso de Windows NT/2000.
Arduino Uno
Para o uso do Arduino n�o tem muita coisa a fazer a �nica coisa a ser feita � a
instala��o dos drivers corretos que vem juntos como o compilador. O compilador
pode ser baixado pelo link que est� em refer�ncias �teis. Para a instala��o plugue
o Arduino na porta USB, ele ira pedir para instalar os drivers corretos. Assim que
abrir a janela para localizar os arquivos a direcione-a para o endere�o em que est�
a pasta dos drivers para continuar a instala��o. Ap�s a instala��o dos drivers, o
Arduino estar� pronto para o uso, lembrando que quando o Arduino estiver sendo
usado com o cabo USB ele n�o deve ser alimentado por uma fonte externa. A
figura 14 mostra o Arduino e suas portas de entrada e sa�da, entrada de sensores,
outras partes de sua estrutura.
Figura 14: Vista superior do Arduino.
25
Sensores
Para este trabalho foi utilizado um sensor de temperatura, mais para outras
atividades pode se usar outros tipos de sensores com de n�vel, ultra-som, chaves
entre outros. O sensor utilizado neste projeto foi o LM35 que � um sensor de
temperatura anal�gico, o LM35 � um sensor de precis�o, fabricado pela National
Semiconductor, que apresenta uma sa�da de tens�o linear proporcional �
temperatura que se encontra ao seu redor, no nosso caso esta tens�o varia de 0V a
5V, o sensor � alimentado com 5V. A figura 15 mostra o sensor LM35 juntamente
com seus terminais.
Figura 15: LM35 e seus terminais.
A liga��o do sensor no Arduino � mostrada na figura 16, a alimenta��o � feita
tamb�m pelo Arduino. Onde o fio vermelho � a alimenta��o de 5V, o fio verde � o
terra e o fio amarelo � onde a tens�o varia de 0V a 5V, sendo ligada na entrada
anal�gica do Arduino.
Figura 16: Esquema de liga��o do sensor na Arduino.
Placa de Rel�
Esta placa � respons�vel por ligar e desligar os dispositivos que nela est�o ligadas,
para produzir a placa � necess�rio certo conhecimento de eletr�nica ou conhecer
algu�m que possa faz�-la. Como ela funciona? Quando os valores dos pinos do
Arduino estiverem em 0 � placa de rel� ficar� desligada, assim que o estado da
26
porta for alterado para 1, o rel� correspondente a porta que foi alterada ir� fechar
seus contatos ligando a carga que estiver ligada no terminal. A figura 17 mostra a
liga��o do Arduino na placa de rel�.
Figura 17: Esquema de liga��o da placa de rel� no Arduino.
Dependendo do layout da placa de rel� a liga��o muda nos pontos de placa, mais a
liga��o no Arduino continua a mesma. Ap�s esta etapa � s� ligar as cargas nos
rel� para poder utilizar.

