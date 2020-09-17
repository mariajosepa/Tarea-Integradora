package model;
import ui.Main;
import java.util.*;


public class Operation { 


 public static final double DESIGN_STAGE = 1300000;
 public static final double POST_CONSTRUCTION = 2600000;
 public static final double PAINT = 980000;


		/**

		Returns the smallest between three numbers
		<b>pre: </b> <br>
		<b>post: Calculates what the best price for x item is </b> <br>

		@param a Price in store #1
		@param b Price in store #2
		@param c Price in store #3
		*/


	public double bestPrice(double a, double b, double c){

		double lowest = 0;


			if (b < a && b < c){

				lowest = b;

			}

			else if (c < a && c < b){

				lowest = c;
			}


			else if (a < b && a < c){

				lowest = a;

			}

			else if (a == b){

				lowest = a;
			}

			else if(b == c){

				lowest = b;
			}

			else if (c == a){

				lowest = c;
			}

		return lowest;

		}


		/**

		 Shows what the best place to purchase an item is depending on its price

		<b>pre:  The best price amongst 3 previously inputted prices has to be calculated and saved to be compared  </b> <br>
		<b>post: Returns a String with the name of the best place to purchase x item comparing its price at x store with the best price found amongst all stores </b> <br>

		@param bestPrice Best price amongst those introduced by user (at different stores)
		@param homeCenter Price at Home Center
		@param ferreteriaBarrio Price at Ferreteria del Barrio
		@param ferreteriaCentro Price at Ferreteria del Centro
		*/



	public String bestPlace(double bestPrice, double homeCenter, double  ferreteriaBarrio, double ferreteriaCentro){

				String bestPlace = "";

				

				if (bestPrice == ferreteriaBarrio && bestPrice == ferreteriaCentro){

					bestPlace = "Ferreteria del Barrio o Ferreteria del Centro";
				}

				else if (bestPrice == ferreteriaBarrio && bestPrice == homeCenter){

					bestPlace = "Ferreteria del Barrio o Home Center";
				}

				else if (bestPrice == ferreteriaCentro && bestPrice == homeCenter){

					bestPlace = "Ferreteria del Centro o Home Center";
				}

				else if (bestPrice == homeCenter && bestPrice == ferreteriaBarrio && bestPrice == ferreteriaCentro){

					bestPlace = "Home Center,Ferreteria del Centro, Ferreteria del Barrio";
				}
							
				else if (bestPrice == ferreteriaCentro){

					bestPlace = "Ferreteria del Centro";
				}

				else if (bestPrice== ferreteriaBarrio){

					bestPlace = "Ferreteria del Barrio";
				}

				else if (bestPrice == homeCenter) {

					bestPlace = "Home Center";
				}
				return bestPlace;


		}


/**

		
		Calculates the delivery fee of the products based on the user's location

		<b>pre: Saved an array containing the best prices and saved the location of the user   </b> <br>
		<b>post: Returns the delivery fee based on location and total cost of items </b> <br>

		@param bestPrice best price amongst those introduced by user. bestPrice != null.
		@param location user's location. location != "".

		*/



	public double sumTotal(double[] bestPrice, String location) {

			double sum = 0;

			 for (int i = 0; i < bestPrice.length;i++){

			 	sum = sum + bestPrice[i];

			 }


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

	/**

			Prints what the best price, place and and name of a material for x category

		<b>pre:  Materials array has to be ready and the best prices and places to buy every material have to have been calculated and stored accordingly </b> <br>
		<b>post: Returns a String with the best place, price and name of every material comparing its index inside a category array with the material's list </b> <br>

		@param numberMaterials total amount of items. numberMaterials > 0.
		@param stage array of all items belonging to x category.
		@param materials list of all materials inputted by the user.
		@param bestPrice best price to buy x item. bestPrice != null.
		@param bestPlace best place to purchase x item.

		*/



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
