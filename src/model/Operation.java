package model;
import ui.Main;
import java.util.*;


public class Operation { 


 public static final double DESIGN_STAGE = 1300000;
 public static final double POST_CONSTRUCTION = 2600000;
 public static final double PAINT = 980000;


	public double bestPrice(double a, double b, double c){

		double lowest = 0;


			if (b < a && b < c){

				lowest = b;

			}

			if (c < a && c < b){

				lowest = c;
			}


			if (a < b && a < c){

				lowest = a;

			}

			if (a == b && b == c){

				lowest = a;
			}

		return lowest;

		}


	public String bestPlace(double bestPrice, double homeCenter, double  ferreteriaBarrio, double ferreteriaCentro){

				String bestPlace = "";

				

				if (bestPrice == homeCenter) {

					bestPlace = "Home Center";
				}

				if (bestPrice== ferreteriaCentro){

					bestPlace = "Ferreteria del Centro";
				}

				if (bestPrice== ferreteriaBarrio){

					bestPlace = "Ferreteria del Barrio";
				}

				if (bestPrice==ferreteriaBarrio && bestPrice == ferreteriaCentro){

					bestPlace = "Ferreteria del Barrio o Ferreteria del Centro";
				}

				if (bestPrice==ferreteriaBarrio && bestPrice == homeCenter){

					bestPlace = "Ferreteria del Barrio o Home Center";
				}

				if (bestPrice==ferreteriaCentro && bestPrice == homeCenter){

					bestPlace = "Ferreteria del Centro o Home Center";
				}

				if (bestPrice==homeCenter && bestPrice == ferreteriaBarrio && bestPrice == ferreteriaCentro){

					bestPlace = "Home Center,Ferreteria del Centro, Ferreteria del Barrio";
				}
					return bestPlace;


		}


	public double sumTotal(double[] bestPrice, String location) {

			double sum = 0;

			 for (int i = 0; i < bestPrice.length;i++){

			 	sum = sum + bestPrice[i];

			 }

			 System.out.println(sum);

			 if (location.equalsIgnoreCase("n")){


			 	if(80000 < sum && sum < 300000){

			 		sum = sum + 28000;
			 	}

			 	if (sum < 80000){

			 		sum  = sum + 120000;
			 	}

			 	if (300000<=sum){

			 		sum = sum;
			 	}

			}


			 if (location.equalsIgnoreCase("c")){


			 	if(80000 < sum && sum < 300000){

			 		sum = sum;
			 	}

			 	if (sum < 80000){

			 		sum  = sum + 50000;
			 	}

			 	if (300000<=sum){

			 		sum = sum;
			 	}

			}


			 if (location.equalsIgnoreCase("s")){

			 	if(80000 < sum && sum < 300000){

			 		sum = sum + 55000;

			 	}

			 	if (sum < 80000){

			 		sum  = sum + 120000;
			 	}

			

			 	if (300000<=sum){

			 		sum = sum;
			 	}

			}


			return sum;


	}


	public void asignPlace (int numberMaterials, String [] stage, String [] materials, double [] bestPrice, String [] bestPlace){

		for (int m = 0; m<numberMaterials;m++){	

				if (stage[m]!=null){
					
						for (int s = 0; s < materials.length;s++){

							if (stage[m] == materials[s]){

							System.out.println("El mejor precio para comprar "+ materials[s] + " es de  "  + bestPrice[s]+ " en " + bestPlace[s]);

					}
				}
			}
       }



	}




}
