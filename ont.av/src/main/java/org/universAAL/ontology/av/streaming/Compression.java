/*
	Copyright 2008-2014 Fraunhofer IGD, http://www.igd.fraunhofer.de
	Fraunhofer-Gesellschaft - Institute for Computer Graphics Research

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

package org.universAAL.ontology.av.streaming;

import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.ontology.av.AVOntology;

/**
 * Ontological representation of a software compression algorithm. Methods
 * included in this class are the mandatory ones for representing an ontological
 * concept in Java classes for universAAL. Usually it includes getters and setters for
 * most of its properties.
 *
 * @author climberg
 * @author Carsten Stockloew
 */
public abstract class Compression extends ManagedIndividual {

	public static final String MY_URI = AVOntology.NAMESPACE + "compression";

	/** The default constructor */
	public Compression() {
		super();
	}

	public Compression(String uri) {
		super(uri);
	}

	public String getClassURI() {
		return MY_URI;
	}

	public int getPropSerializationType(String propURI) {
		return PROP_SERIALIZATION_FULL;
	}
}
