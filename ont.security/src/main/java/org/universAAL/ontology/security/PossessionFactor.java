/*******************************************************************************
 * Copyright 2015 2011 Universidad Politécnica de Madrid
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
package org.universAAL.ontology.security;

/**
 * @author amedrano
 *
 */
public abstract class PossessionFactor extends Factor {
	public static final String MY_URI = SecurityOntology.NAMESPACE + "PossessionFactor";

	/**
	 * Only for serializers.
	 */
	public PossessionFactor() {
		super();
	}

	/**
	 * @param uri
	 */
	public PossessionFactor(String uri) {
		super(uri);
	}

	/** {@ inheritDoc} */
	public String getClassURI() {
		return MY_URI;
	}

	/** {@ inheritDoc} */
	public boolean isWellFormed() {
		return super.isWellFormed();
	}

	/** {@ inheritDoc} */
	public int getPropSerializationType(String propURI) {
		return PROP_SERIALIZATION_UNDEFINED;
	}
}
