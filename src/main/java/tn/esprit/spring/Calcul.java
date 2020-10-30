package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calcul {
	private static final Logger logger = LogManager.getLogger(Calcul.class);

	public int calculerSom (int a, int b) {
	int res = 0;
	try {
	logger.info("In calculerSom(" + a + ", " + b + ")");
	res = a+ b;
	logger.info("Out calculerSom() : " + res);
	} catch (Exception e) {logger.error("Erreur : " + e);}
	return res;
	}
	
	public int calculerDiff (int a, int b)
	{
	int res = 0;
	try {
	logger.info("In calculerDiff(" + a + ", " + b + ")");
	res = a - b;
	logger.info("Out calculerDiff() : " + res);
	}
	catch (Exception e) { logger.error("Erreur : " + e);
	}
	return res;
	}
}
