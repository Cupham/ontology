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
package org.universAAL.ontology.sysinfo;

import org.universAAL.middleware.owl.ManagedIndividual;

/**
 * Ontological representation of SystemInfo in the sysinfo ontology. Methods
 * included in this class are the mandatory ones for representing an ontological
 * concept in Java classes for the universAAL platform. In addition getters and
 * setters for properties are included.
 *
 * @author
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public class SystemInfo extends ManagedIndividual {
	public static final String MY_URI = SysinfoOntology.NAMESPACE + "SystemInfo";
	public static final String PROP_SPACE_CHANGED = SysinfoOntology.NAMESPACE + "spaceChanged";
	public static final String PROP_SPACE_JOINED = SysinfoOntology.NAMESPACE + "spaceJoined";
	public static final String PROP_PEER_JOINED = SysinfoOntology.NAMESPACE + "peerJoined";
	public static final String PROP_SPACE_LOST = SysinfoOntology.NAMESPACE + "spaceLost";
	public static final String PROP_PEER_LOST = SysinfoOntology.NAMESPACE + "peerLost";
	public static final String PROP_ALIVE = SysinfoOntology.NAMESPACE + "alive";

	public SystemInfo() {
		super();
	}

	public SystemInfo(String uri) {
		super(uri);
	}

	public String getClassURI() {
		return MY_URI;
	}

	public int getPropSerializationType(String propURI) {
		return PROP_SERIALIZATION_FULL;
	}

	public boolean isWellFormed() {
		return true;
	}

	public AALSpaceDescriptor getSpaceJoined() {
		return (AALSpaceDescriptor) getProperty(PROP_SPACE_JOINED);
	}

	public void setSpaceJoined(AALSpaceDescriptor newPropValue) {
		if (newPropValue != null)
			changeProperty(PROP_SPACE_JOINED, newPropValue);
	}

	public PeerCardDescriptor getPeerJoined() {
		return (PeerCardDescriptor) getProperty(PROP_PEER_JOINED);
	}

	public void setPeerJoined(PeerCardDescriptor newPropValue) {
		if (newPropValue != null)
			changeProperty(PROP_PEER_JOINED, newPropValue);
	}

	public AALSpaceStatusDescriptor getSpaceChanged() {
		return (AALSpaceStatusDescriptor) getProperty(PROP_SPACE_CHANGED);
	}

	public void setSpaceChanged(AALSpaceStatusDescriptor newPropValue) {
		if (newPropValue != null)
			changeProperty(PROP_SPACE_CHANGED, newPropValue);
	}

	public AALSpaceDescriptor getSpaceLost() {
		return (AALSpaceDescriptor) getProperty(PROP_SPACE_LOST);
	}

	public void setSpaceLost(AALSpaceDescriptor newPropValue) {
		if (newPropValue != null)
			changeProperty(PROP_SPACE_LOST, newPropValue);
	}

	public PeerCardDescriptor getPeerLost() {
		return (PeerCardDescriptor) getProperty(PROP_PEER_LOST);
	}

	public void setPeerLost(PeerCardDescriptor newPropValue) {
		if (newPropValue != null)
			changeProperty(PROP_PEER_LOST, newPropValue);
	}

	public Boolean getAlive() {
		return (Boolean) getProperty(PROP_ALIVE);
	}

	public void setAlive(Boolean alive) {
		if (alive != null)
			changeProperty(PROP_ALIVE, alive);
	}

}
