/*******************************************************************************
 * Copyright 2015 UPM - Universidad Politécnica de Madrid
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.universAAL.ontology.hvac;

import org.universAAL.middleware.owl.ManagedIndividual;


/**
 * @author Ricardo
 * Description: Level is used for set the intensity of fan and swing
 */
public class Level extends Hvac {
    public static final String MY_URI = HvacOntology.NAMESPACE + "Level";

    public static final int HIGH = 2;
    public static final int MED = 1;
    public static final int LOW = 0;
    
    protected static final String[] names = { "high", "med",
	    "low" };

    public static final Level high = new Level(HIGH);
    public static final Level med = new Level(MED);
    public static final Level low = new Level(LOW);

    protected static int order;

    protected Level(int order) {
	super(HvacOntology.NAMESPACE + names[order]);
	this.order = order;
    }

    public int getPropSerializationType(String propURI) {
	return PROP_SERIALIZATION_OPTIONAL;
    }

    public boolean isWellFormed() {
	return true;
    }

    public String name() {
	return names[order];
    }

    public int ord() {
	return order;
    }

    public String getClassURI() {
	return MY_URI;
    }

    public static Level getLevelByOrder(int order) {
	switch (order) {
	case HIGH:
	    return high;
	case MED:
	    return med;
	case LOW:
	    return low;
	default:
	    return null;
	}
    }

    public static final Level valueOf(String name) {
	if (name == null)
	    return null;

	if (name.startsWith(HvacOntology.NAMESPACE))
	    name = name.substring(HvacOntology.NAMESPACE.length());

	for (int i =LOW ; i <= HIGH; i++)
	    if (names[i].equals(name))
		return getLevelByOrder(i);

	return null;
    }
  
}
