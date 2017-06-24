/*
	Copyright 2008-2014 ITACA-TSB, http://www.tsb.upv.es
	Instituto Tecnologico de Aplicaciones de Comunicacion
	Avanzadas - Grupo Tecnologias para la Salud y el
	Bienestar (TSB)

	See the NOTICE file distributed with this work for additional
	information regarding copyright ownership

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	  http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package org.universAAL.ontology.device.home;

import org.universAAL.ontology.device.Sensor;
import org.universAAL.ontology.device.StatusValue;

/**
 * Ontological representation of a pressure sensor embedded on a carpet. Methods
 * included in this class are the mandatory ones for representing an ontological
 * concept in Java classes for uAAL. Usually it includes getters and setters for
 * most of its properties.
 *
 * @author <a href="mailto:alfiva@itaca.upv.es">Alvaro Fides Valero</a>
 *
 */
public class CarpetSensor extends Sensor {

	/** Class URI */
	public static final String MY_URI = DeviceExtraOntology.NAMESPACE + "CarpetSensor";

	public CarpetSensor() {
	}

	public CarpetSensor(String uri) {
		super(uri);
	}

	public String getClassURI() {
		return MY_URI;
	}

	public int getPropSerializationType(String propURI) {
		return PROP_SERIALIZATION_FULL;
	}

	public boolean isWellFormed() {
		return true && hasProperty(PROP_HAS_VALUE);
	}

	public StatusValue getValue() {
		return (StatusValue) getProperty(PROP_HAS_VALUE);
	}

	public void setValue(StatusValue newPropValue) {
		if (newPropValue != null)
			changeProperty(PROP_HAS_VALUE, newPropValue);
	}

}
