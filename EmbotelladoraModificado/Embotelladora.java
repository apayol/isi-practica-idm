//package sut_code;
import java.lang.Math;

public class Embotelladora {

  /**
  * @param pequenas botellas pequeñas
  * @param grandes botellas grandes
  * @param total litros totales
  * @return numero de botellas pequeñas necesarias
  * @throws IllegalArgumentException if params <= 0
  */
  public static int calculaBotellasPequenas(int pequenas, int grandes, int total) {
    //minimizar pequeñas (primero se rellenan grandes)

    if (pequenas < 0 || grandes < 0 || total <= 0 || (pequenas == 0 && grandes == 0)){
      throw new IllegalArgumentException("Embotelladora.calculaBotellasPequenas");
    }

    if (pequenas == 0){ //tiene que haber grandes si o si
      if (total/5 <= grandes){ //p.e. 30l, 6g | 32l, 7 g
        int num_grandes = Math.round (total/5); //no nos hace falta, pero lo guardo
        return 0;
      }else{
        return -1;
        // throw new IllegalArgumentException("Embotelladora.calculaBotellasPequenas");
        //no podemos rellenar todos los litros solo con las grandes
      }
    }

    if (grandes == 0){ //tiene que haber pequeñas si o si
      if (pequenas >= total){ //p.e. 10l 12 peq
        return total;
      }else{
        return -1;
        // throw new IllegalArgumentException("Embotelladora.calculaBotellasPequenas");
        //no rellenamos todos los litros solo con las pequeñas
      }
    }

    //caso grandes > pequeñas | pequeñas > grandes
    int resto = total - (5*grandes);
    if (resto <= 0){ //p.e. 30l, 6g | 32l, 7 g
      int num_grandes = Math.round (total/5); //no nos hace falta, pero lo guardo
      return 0;
    }else{ //el sobrante, para rellenar con pequenas
      if (pequenas >= resto){
        return resto;
      }else{
        return -1;
        // throw new IllegalArgumentException("Embotelladora.calculaBotellasPequenas");
        //no rellenamos todos los litros con grandes+peq
      }
    }
  }

  public static void main (String args[]){
    Embotelladora test = new Embotelladora();
    // System.out.println(test.calculaBotellasPequenas(-10,10,10)); //ERROR
    // System.out.println(test.calculaBotellasPequenas(10,-10,10)); //ERROR
    // System.out.println(test.calculaBotellasPequenas(10,10,0)); //ERROR
    // System.out.println(test.calculaBotellasPequenas(0,0,10)); //ERROR

    System.out.println(test.calculaBotellasPequenas(0,10,20)); //OK 0 bot
    System.out.println(test.calculaBotellasPequenas(0,10,22)); //OK 0 bot
    // System.out.println(test.calculaBotellasPequenas(0,3,15)); //NO OK

    System.out.println(test.calculaBotellasPequenas(10,0,10)); //OK 10 bot
    System.out.println(test.calculaBotellasPequenas(10,0,5)); //OK 5 bot
    // System.out.println(test.calculaBotellasPequenas(10,0,12)); //NO OK

    System.out.println(test.calculaBotellasPequenas(10,10,10)); //OK 0 bot
    System.out.println(test.calculaBotellasPequenas(10,2,10)); //OK 0 bot
    System.out.println(test.calculaBotellasPequenas(10,1,7)); //OK 2 bot
    // System.out.println(test.calculaBotellasPequenas(1,1,7)); //NO OK

  }
}
