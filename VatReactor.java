// http://en.wikipedia.org/wiki/Continuous_stirred-tank_reactor
// N_i = integral(F_in - F_out + V*v_i*r_i)dt

// N_i moles of species i in the reactor
// F_in is the molar flow rate inlet of species i
// F_out the molar flow rate outlet
// V reactor volume
// v_i stoichiometric coefficient
// r_i reaction rate

//import java.lang.Math;

public class VatReactor extends Thread
{
		private static double N_i = 0;
		private static double F_in = 1;
		private static double F_out = 1;
		private static double Volume = 10;
		private static double v_i = 0.5;
		private static double r_i = 0.1;
		private static long dt = 1;
		private static long t_max = 100;
	
	public static void main(String[] args) {	

		for(long t = 0; t <= t_max; t += dt) {
			System.out.println("Current moles of species : " + N_i + " at time " + t);
			N_i += (F_in - F_out + Volume*v_i*r_i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}