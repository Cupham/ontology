/*******************************************************************************
 * Copyright 2016 Universidad Politécnica de Madrid UPM
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
package org.universAAL.ontology.cryptographic;

import org.universAAL.middleware.owl.DataRepOntology;
import org.universAAL.middleware.owl.HasValueRestriction;
import org.universAAL.middleware.owl.IntRestriction;
import org.universAAL.middleware.owl.ManagedIndividual;
import org.universAAL.middleware.owl.MergedRestriction;
import org.universAAL.middleware.owl.ObjectPropertySetup;
import org.universAAL.middleware.owl.OntClassInfoSetup;
import org.universAAL.middleware.owl.Ontology;
import org.universAAL.middleware.owl.TypeExpression;
import org.universAAL.middleware.owl.Union;
import org.universAAL.middleware.rdf.Resource;
import org.universAAL.middleware.rdf.TypeMapper;
import org.universAAL.middleware.service.owl.Service;
import org.universAAL.middleware.service.owl.ServiceBusOntology;
import org.universAAL.middleware.xsd.Base64Binary;
import org.universAAL.ontology.CryptographicFactory;
import org.universAAL.ontology.cryptographic.asymmetric.DSA;
import org.universAAL.ontology.cryptographic.asymmetric.RSA;
import org.universAAL.ontology.cryptographic.digest.MessageDigest;
import org.universAAL.ontology.cryptographic.digest.SecureHashAlgorithm;
import org.universAAL.ontology.cryptographic.symmetric.AES;
import org.universAAL.ontology.cryptographic.symmetric.Blowfish;
import org.universAAL.ontology.cryptographic.symmetric.DES;
//import the factory for this ontology


/**
 * This class provides the main representation of the cryptographic ontology 
 * for the universAAL platform.
 *
 * @author Generated by the OntologyUML2Java transformation of AAL Studio
 */
public final class CryptographicOntology extends Ontology {

  private static CryptographicFactory factory = new CryptographicFactory();
  public static final String NAMESPACE ="http://ontology.universAAL.org/Cryptographic#";
	
  public CryptographicOntology() {
    super(NAMESPACE);
  }

  public void create() {
    Resource r = getInfo();
    r.setResourceComment("");
    r.setResourceLabel("cryptographic");
    addImport(DataRepOntology.NAMESPACE);
    addImport(ServiceBusOntology.NAMESPACE);

    // TODO: Add any additionally imported ontologies here
    

    // ******* Declaration of enumeration classes of the ontology ******* //
    OntClassInfoSetup oci_ChainMode = createNewAbstractOntClassInfo(ChainMode.MY_URI);

    // ******* Declaration of regular classes of the ontology ******* //
    OntClassInfoSetup oci_DigestService = createNewOntClassInfo(DigestService.MY_URI, factory, 0);
    OntClassInfoSetup oci_SimpleKey = createNewOntClassInfo(SimpleKey.MY_URI, factory, 1);
    OntClassInfoSetup oci_KeyRing = createNewOntClassInfo(KeyRing.MY_URI, factory, 2);
    OntClassInfoSetup oci_AsymmetricEncryption = createNewAbstractOntClassInfo(AsymmetricEncryption.MY_URI);
    OntClassInfoSetup oci_BlockEncryption = createNewAbstractOntClassInfo(BlockEncryption.MY_URI);
    OntClassInfoSetup oci_Digest = createNewAbstractOntClassInfo(Digest.MY_URI);
    OntClassInfoSetup oci_SimpleBlockEncryption = createNewAbstractOntClassInfo(SimpleBlockEncryption.MY_URI);
    OntClassInfoSetup oci_MultidestinationEncryptedResource = createNewOntClassInfo(MultidestinationEncryptedResource.MY_URI, factory, 3);
    OntClassInfoSetup oci_EncryptionKey = createNewAbstractOntClassInfo(EncryptionKey.MY_URI);
    OntClassInfoSetup oci_ChainedBlockEncryption = createNewAbstractOntClassInfo(ChainedBlockEncryption.MY_URI);
    OntClassInfoSetup oci_EncryptionService = createNewOntClassInfo(EncryptionService.MY_URI, factory, 4);
    OntClassInfoSetup oci_SignedResource = createNewOntClassInfo(SignedResource.MY_URI, factory, 5);
    OntClassInfoSetup oci_CertificationAuthority = createNewOntClassInfo(CertificationAuthority.MY_URI, factory, 6);
    OntClassInfoSetup oci_CryptographicTechnique = createNewAbstractOntClassInfo(CryptographicTechnique.MY_URI);
    OntClassInfoSetup oci_EncryptedResource = createNewOntClassInfo(EncryptedResource.MY_URI, factory, 7);
    OntClassInfoSetup oci_CryptograpichService = createNewOntClassInfo(CryptographicService.MY_URI, factory, 8);
    OntClassInfoSetup oci_StreamEncryption = createNewAbstractOntClassInfo(StreamEncryption.MY_URI);
    OntClassInfoSetup oci_KeyExchange = createNewAbstractOntClassInfo(KeyExchange.MY_URI);
    OntClassInfoSetup oci_SymmetricEncryption = createNewAbstractOntClassInfo(SymmetricEncryption.MY_URI);
    OntClassInfoSetup oci_SignAndVerifyService = createNewOntClassInfo(SignAndVerifyService.MY_URI, factory, 9);
    OntClassInfoSetup oci_Encryption = createNewAbstractOntClassInfo(Encryption.MY_URI);
    

    OntClassInfoSetup oci_messageDigest = createNewOntClassInfo(MessageDigest.MY_URI, factory, 10);
    OntClassInfoSetup oci_SecureHashAlgorithm = createNewOntClassInfo(SecureHashAlgorithm.MY_URI, factory, 11);

    // ******* Add content to enumeration classes of the ontology ******* //

    oci_ChainMode.setResourceComment("");
    oci_ChainMode.setResourceLabel("ChainMode");
    oci_ChainMode.toEnumeration(new ManagedIndividual[] {
       ChainMode.Enc, ChainMode.Dec });


    // ******* Add content to regular classes of the ontology ******* //
    oci_DigestService.setResourceComment("");
    oci_DigestService.setResourceLabel("Digest Service");
    oci_DigestService.addSuperClass(CryptographicService.MY_URI); 
    oci_DigestService.addObjectProperty(DigestService.PROP_RESOURCE_TO_DIGEST).setFunctional();
    oci_DigestService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(DigestService.PROP_RESOURCE_TO_DIGEST, 
          TypeMapper.getDatatypeURI(Resource.class), 1, 1));
    oci_DigestService.addDatatypeProperty(DigestService.PROP_DIGESTED_TEXT).setFunctional();
    oci_DigestService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(DigestService.PROP_DIGESTED_TEXT, 
          TypeMapper.getDatatypeURI(Base64Binary.class), 1, 1));
    oci_DigestService.addObjectProperty(DigestService.PROP_DIGEST_METHOD).setFunctional();
    oci_DigestService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(DigestService.PROP_DIGEST_METHOD, 
          Digest.MY_URI, 1, 1));

    oci_SimpleKey.setResourceComment("A simple Key used to (de)cypher symmetrically text.");
    oci_SimpleKey.setResourceLabel("Simple Key");
    oci_SimpleKey.addSuperClass(EncryptionKey.MY_URI); 
    oci_SimpleKey.addDatatypeProperty(SimpleKey.PROP_KEY_TEXT).setFunctional();
    oci_SimpleKey.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SimpleKey.PROP_KEY_TEXT, 
          TypeMapper.getDatatypeURI(Base64Binary.class), 1, 1));

    oci_KeyRing.setResourceComment("A placeholder for key pairs (public and private keys).");
    oci_KeyRing.setResourceLabel("Key Ring");
    oci_KeyRing.addSuperClass(EncryptionKey.MY_URI); 
    oci_KeyRing.addDatatypeProperty(KeyRing.PROP_PRIVATE_KEY).setFunctional();
    oci_KeyRing.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(KeyRing.PROP_PRIVATE_KEY, 
          TypeMapper.getDatatypeURI(Base64Binary.class), 0, 1));
    oci_KeyRing.addObjectProperty(KeyRing.PROP_CERTIFICATION_AUTHORITY).setFunctional();
      	oci_KeyRing.addRestriction(MergedRestriction.getAllValuesRestriction(KeyRing.PROP_CERTIFICATION_AUTHORITY,  
       	CertificationAuthority.MY_URI));
    oci_KeyRing.addDatatypeProperty(KeyRing.PROP_PUBLIC_KEY).setFunctional();
    oci_KeyRing.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(KeyRing.PROP_PUBLIC_KEY, 
          TypeMapper.getDatatypeURI(Base64Binary.class), 0, 1));

    oci_AsymmetricEncryption.setResourceComment("Any cryptographic system that uses pairs of keys.");
    oci_AsymmetricEncryption.setResourceLabel("Asymmetric Encryption");
    oci_AsymmetricEncryption.addSuperClass(Encryption.MY_URI); 
    ObjectPropertySetup akey = oci_AsymmetricEncryption.addObjectProperty(AsymmetricEncryption.PROP_KEY_RING);
    akey.setFunctional();
    akey.addSuperProperty(Encryption.PROP_KEY);
    oci_AsymmetricEncryption.addRestriction(MergedRestriction.getAllValuesRestriction(AsymmetricEncryption.PROP_KEY_RING,  
    		KeyRing.MY_URI));

    oci_BlockEncryption.setResourceComment("");
    oci_BlockEncryption.setResourceLabel("Block Encryption");
    oci_BlockEncryption.addSuperClass(SymmetricEncryption.MY_URI); 
    oci_BlockEncryption.addDatatypeProperty(BlockEncryption.PROP_BLOCK_LENGTH).setFunctional();
    oci_BlockEncryption.addRestriction(MergedRestriction
    		.getAllValuesRestrictionWithCardinality(BlockEncryption.PROP_BLOCK_LENGTH, 
    				TypeMapper.getDatatypeURI(Integer.class), 1, 1));

    oci_Digest.setResourceComment("");
    oci_Digest.setResourceLabel("Digest");
    oci_Digest.addSuperClass(CryptographicTechnique.MY_URI); 

    oci_SimpleBlockEncryption.setResourceComment("");
    oci_SimpleBlockEncryption.setResourceLabel("Simple Block Encryption");
    oci_SimpleBlockEncryption.addSuperClass(BlockEncryption.MY_URI); 

    oci_MultidestinationEncryptedResource.setResourceComment("An encrypted resource which has different destinataries.");
    oci_MultidestinationEncryptedResource.setResourceLabel("Multidestination Encrypted Resource");
    oci_MultidestinationEncryptedResource.addSuperClass(EncryptedResource.MY_URI); 
    oci_MultidestinationEncryptedResource.addObjectProperty(MultidestinationEncryptedResource.PROP_KEY).setFunctional();
    oci_MultidestinationEncryptedResource.addRestriction(MergedRestriction
      .getAllValuesRestriction(MultidestinationEncryptedResource.PROP_KEY, 
          EncryptionKey.MY_URI));

    oci_EncryptionKey.setResourceComment("Key used to (de)cypher messages.");
    oci_EncryptionKey.setResourceLabel("Encryption Key");
    oci_EncryptionKey.addSuperClass(ManagedIndividual.MY_URI); 

    oci_ChainedBlockEncryption.setResourceComment("");
    oci_ChainedBlockEncryption.setResourceLabel("Chained Block Encryption");
    oci_ChainedBlockEncryption.addSuperClass(BlockEncryption.MY_URI); 
    oci_ChainedBlockEncryption.addObjectProperty(ChainedBlockEncryption.PROP_CHAIN_MODE).setFunctional();
      	oci_ChainedBlockEncryption.addRestriction(MergedRestriction.getAllValuesRestriction(ChainedBlockEncryption.PROP_CHAIN_MODE,  
       	ChainMode.MY_URI));
    oci_ChainedBlockEncryption.addObjectProperty(ChainedBlockEncryption.PROP_SIMPLE).setFunctional();
    oci_ChainedBlockEncryption.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(ChainedBlockEncryption.PROP_SIMPLE, 
          SimpleBlockEncryption.MY_URI, 1, 1));

    oci_EncryptionService.setResourceComment("Service to (de)encrypt RDF resources.");
    oci_EncryptionService.setResourceLabel("Encryption Service");
    oci_EncryptionService.addSuperClass(CryptographicService.MY_URI); 
    oci_EncryptionService.addObjectProperty(EncryptionService.PROP_ENCRYPTED_RESOURCE).setFunctional();
    oci_EncryptionService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(EncryptionService.PROP_ENCRYPTED_RESOURCE, 
          EncryptedResource.MY_URI, 1, 1));
    oci_EncryptionService.addObjectProperty(EncryptionService.PROP_ENCRYPTION).setFunctional();
    oci_EncryptionService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(EncryptionService.PROP_ENCRYPTION, 
          Encryption.MY_URI, 1, 1));
    oci_EncryptionService.addObjectProperty(EncryptionService.PROP_ENCRYPTS).setFunctional();
    oci_EncryptionService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(EncryptionService.PROP_ENCRYPTS, 
          TypeMapper.getDatatypeURI(Resource.class), 1, 1));

    oci_SignedResource.setResourceComment("A wrapper that includes a digital signature and the metainformation to validate.");
    oci_SignedResource.setResourceLabel("Signed Resource");
    oci_SignedResource.addSuperClass(ManagedIndividual.MY_URI); 
    oci_SignedResource.addDatatypeProperty(SignedResource.PROP_SIGNATURE).setFunctional();
    oci_SignedResource.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignedResource.PROP_SIGNATURE, 
          TypeMapper.getDatatypeURI(Base64Binary.class), 1, -1));
    oci_SignedResource.addObjectProperty(SignedResource.PROP_ASYMMETRIC).setFunctional();
    oci_SignedResource.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignedResource.PROP_ASYMMETRIC, 
          AsymmetricEncryption.MY_URI, 1, 1));
    oci_SignedResource.addObjectProperty(SignedResource.PROP_SIGNED_RESOURCE).setFunctional();
    oci_SignedResource.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignedResource.PROP_SIGNED_RESOURCE, 
          TypeMapper.getDatatypeURI(Resource.class), 1, 1));
    oci_SignedResource.addObjectProperty(SignedResource.PROP_DIGEST).setFunctional();
    oci_SignedResource.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignedResource.PROP_DIGEST, 
          Digest.MY_URI, 1, 1));


    oci_CertificationAuthority.setResourceComment("An entity that issues digital certificates.");
    oci_CertificationAuthority.setResourceLabel("Certification Authority");
    oci_CertificationAuthority.addSuperClass(KeyRing.MY_URI); 
    oci_CertificationAuthority.addSuperClass(SignedResource.MY_URI); 

    oci_CryptographicTechnique.setResourceComment("All the cryptographic techniques.");
    oci_CryptographicTechnique.setResourceLabel("CryptographicTechnique");
    oci_CryptographicTechnique.addSuperClass(ManagedIndividual.MY_URI); 

    oci_EncryptedResource.setResourceComment("An cyphered text that when decrypted is the serialised form of a RDF resource. It also contains all the necesary information to perform the decryption process correctly.");
    oci_EncryptedResource.setResourceLabel("Encrypted Resource");
    oci_EncryptedResource.addSuperClass(ManagedIndividual.MY_URI); 
    oci_EncryptedResource.addObjectProperty(EncryptedResource.PROP_ENCRYPTION).setFunctional();
    oci_EncryptedResource.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(EncryptedResource.PROP_ENCRYPTION, 
          Encryption.MY_URI, 1, 1));
    oci_EncryptedResource.addDatatypeProperty(EncryptedResource.PROP_CYPHERED_TEXT).setFunctional();
    oci_EncryptedResource.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(EncryptedResource.PROP_CYPHERED_TEXT, 
          TypeMapper.getDatatypeURI(Base64Binary.class), 1, 1));

    oci_CryptograpichService.setResourceComment("Simple Criptographic serives.");
    oci_CryptograpichService.setResourceLabel("Cryptographic Service");
    oci_CryptograpichService.addSuperClass(Service.MY_URI); 

    oci_StreamEncryption.setResourceComment("");
    oci_StreamEncryption.setResourceLabel("Stream Encryption");
    oci_StreamEncryption.addSuperClass(SymmetricEncryption.MY_URI); 
    oci_StreamEncryption.addDatatypeProperty(StreamEncryption.PROP_INITIALIZATION_VECTOR).setFunctional();
    oci_StreamEncryption.addRestriction(MergedRestriction.getAllValuesRestrictionWithCardinality(
    		StreamEncryption.PROP_INITIALIZATION_VECTOR,TypeMapper.getDatatypeURI(Base64Binary.class), 1, 1));

    oci_KeyExchange.setResourceComment("");
    oci_KeyExchange.setResourceLabel("Key Exchange");
    oci_KeyExchange.addSuperClass(CryptographicTechnique.MY_URI); 

    oci_SymmetricEncryption.setResourceComment("Algorithms for cryptography that use the same cryptographic keys for both encryption of plaintext and decryption of ciphertext.");
    oci_SymmetricEncryption.setResourceLabel("Symmetric Encryption");
    oci_SymmetricEncryption.addSuperClass(Encryption.MY_URI); 
    ObjectPropertySetup skey = oci_SymmetricEncryption.addObjectProperty(SymmetricEncryption.PROP_SIMPLE_KEY);
    skey.setFunctional();
    skey.addSuperProperty(Encryption.PROP_KEY);
    oci_SymmetricEncryption.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SymmetricEncryption.PROP_SIMPLE_KEY, 
          SimpleKey.MY_URI, 0, 1));

    oci_SignAndVerifyService.setResourceComment("Service to sign or verify signatures of RDF resources.");
    oci_SignAndVerifyService.setResourceLabel("Sign And Verify Service");
    oci_SignAndVerifyService.addSuperClass(CryptographicService.MY_URI); 
    oci_SignAndVerifyService.addObjectProperty(SignAndVerifyService.PROP_SIGN).setFunctional();
    oci_SignAndVerifyService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignAndVerifyService.PROP_SIGN, 
          TypeMapper.getDatatypeURI(Resource.class), 1, 1));
    oci_SignAndVerifyService.addObjectProperty(SignAndVerifyService.PROP_SIGNED_RESOURCE).setFunctional();
    oci_SignAndVerifyService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignAndVerifyService.PROP_SIGNED_RESOURCE, 
          SignedResource.MY_URI, 1, -1));
    oci_SignAndVerifyService.addObjectProperty(SignAndVerifyService.PROP_ASYMMETRIC).setFunctional();
    oci_SignAndVerifyService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignAndVerifyService.PROP_ASYMMETRIC, 
          AsymmetricEncryption.MY_URI, 1, 1));
    oci_SignAndVerifyService.addObjectProperty(SignAndVerifyService.PROP_KEY_RING).setFunctional();
    oci_SignAndVerifyService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignAndVerifyService.PROP_KEY_RING, 
          KeyRing.MY_URI, 1, -1));
    oci_SignAndVerifyService.addDatatypeProperty(SignAndVerifyService.PROP_VERIFICATION_RESULT).setFunctional();
    oci_SignAndVerifyService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignAndVerifyService.PROP_VERIFICATION_RESULT, 
          TypeMapper.getDatatypeURI(Boolean.class), 1, 1));
    oci_SignAndVerifyService.addObjectProperty(SignAndVerifyService.PROP_DIGEST).setFunctional();
    oci_SignAndVerifyService.addRestriction(MergedRestriction
      .getAllValuesRestrictionWithCardinality(SignAndVerifyService.PROP_DIGEST, 
          Digest.MY_URI, 1, 1));

    oci_Encryption.setResourceComment("The process of encoding messages or information in such a way that only authorized parties can read it.");
    oci_Encryption.setResourceLabel("Encryption");
    oci_Encryption.addSuperClass(CryptographicTechnique.MY_URI); 
    oci_Encryption.addObjectProperty(Encryption.PROP_KEY).setFunctional();
      	oci_Encryption.addRestriction(MergedRestriction.getAllValuesRestriction(Encryption.PROP_KEY,  
       	EncryptionKey.MY_URI));
      	
    oci_messageDigest.setResourceComment("All Message Digest (MDx) disgest algorithms.");
    oci_messageDigest.setResourceLabel("Message Digest (MDx)");
    oci_messageDigest.addSuperClass(Digest.MY_URI);
    oci_messageDigest.addInstance(MessageDigest.IND_MD2);
    oci_messageDigest.addInstance(MessageDigest.IND_MD5);
    //XXX add more MDx algorithms as they are implemented in Java
    
    oci_SecureHashAlgorithm.setResourceComment("All Secure Hash algorithm types.");
    oci_SecureHashAlgorithm.setResourceLabel("Secure Hash Algorithm (SHA)");
    oci_SecureHashAlgorithm.addSuperClass(Digest.MY_URI);
    oci_SecureHashAlgorithm.addInstance(SecureHashAlgorithm.IND_SHA);
    oci_SecureHashAlgorithm.addInstance(SecureHashAlgorithm.IND_SHA256);
    oci_SecureHashAlgorithm.addInstance(SecureHashAlgorithm.IND_SHA384);
    oci_SecureHashAlgorithm.addInstance(SecureHashAlgorithm.IND_SHA512);
    //XXX add more SHA algorithms as they are implemented in Java

    /*
     * Symmetric algorithms
     */    
    
    // AES
    OntClassInfoSetup oci_aes = createNewOntClassInfo(AES.MY_URI, factory, 12);
    oci_aes.addSuperClass(SimpleBlockEncryption.MY_URI);
    MergedRestriction keymr = MergedRestriction.getAllValuesRestrictionWithCardinality(SymmetricEncryption.PROP_SIMPLE_KEY, SimpleKey.MY_URI, 0, 1);
    TypeExpression possibleKeyLengths = new Union();
    ((Union)possibleKeyLengths).addType(new HasValueRestriction(SimpleKey.PROP_KEY_LENGTH, new Integer(128)));
    ((Union)possibleKeyLengths).addType(new HasValueRestriction(SimpleKey.PROP_KEY_LENGTH, new Integer(192)));
    ((Union)possibleKeyLengths).addType(new HasValueRestriction(SimpleKey.PROP_KEY_LENGTH, new Integer(256)));
    MergedRestriction keylengthmr = MergedRestriction.getAllValuesRestrictionWithCardinality(SimpleKey.PROP_KEY_LENGTH,possibleKeyLengths,1,1);
    keylengthmr.appendTo(keymr, new String[]{SymmetricEncryption.PROP_SIMPLE_KEY,SimpleKey.PROP_KEY_LENGTH});
    oci_aes.addRestriction(keymr);
    // TO BE TESTED!
    // TODO use length restriction on SimpleKey.PROP_KEY_TEXT
    oci_aes.addRestriction(MergedRestriction.getFixedValueRestriction(BlockEncryption.PROP_BLOCK_LENGTH, new Integer(128)));
    
    // Blowfish
    OntClassInfoSetup oci_blowfish = createNewOntClassInfo(Blowfish.MY_URI, factory, 13);
    oci_blowfish.addSuperClass(SimpleBlockEncryption.MY_URI);
     keymr = MergedRestriction.getAllValuesRestrictionWithCardinality(SymmetricEncryption.PROP_SIMPLE_KEY, SimpleKey.MY_URI, 0, 1);
    possibleKeyLengths = new IntRestriction(32, true, 448, true);
    keylengthmr = MergedRestriction.getAllValuesRestrictionWithCardinality(SimpleKey.PROP_KEY_LENGTH,possibleKeyLengths,1,1);
    keylengthmr.appendTo(keymr, new String[]{SymmetricEncryption.PROP_SIMPLE_KEY,SimpleKey.PROP_KEY_LENGTH});
    oci_blowfish.addRestriction(keymr);
    // TODO use length restriction on SimpleKey.PROP_KEY_TEXT
    oci_blowfish.addRestriction(MergedRestriction.getFixedValueRestriction(BlockEncryption.PROP_BLOCK_LENGTH, new Integer(64)));
    
    // DES
    OntClassInfoSetup oci_des = createNewOntClassInfo(DES.MY_URI, factory, 14);
    oci_des.addSuperClass(SimpleBlockEncryption.MY_URI);
    keymr = MergedRestriction.getAllValuesRestrictionWithCardinality(SymmetricEncryption.PROP_SIMPLE_KEY, SimpleKey.MY_URI, 0, 1);
    keylengthmr = MergedRestriction.getFixedValueRestriction(SimpleKey.PROP_KEY_LENGTH, new Integer(56));
    keylengthmr.appendTo(keymr, new String[]{SymmetricEncryption.PROP_SIMPLE_KEY,SimpleKey.PROP_KEY_LENGTH});
    oci_des.addRestriction(keymr);
    // TODO use length restriction on SimpleKey.PROP_KEY_TEXT
    oci_des.addRestriction(MergedRestriction.getFixedValueRestriction(BlockEncryption.PROP_BLOCK_LENGTH, new Integer(64)));
    
    /*
     * Asymmetric algorithms
     */
    //DSA
    OntClassInfoSetup oci_dsa = createNewOntClassInfo(DSA.MY_URI, factory, 15);
    oci_dsa.addSuperClass(AsymmetricEncryption.MY_URI);
    oci_dsa.setResourceLabel("RSA");

    //RSA
    OntClassInfoSetup oci_rsa = createNewOntClassInfo(RSA.MY_URI, factory, 16);
    oci_rsa.setResourceLabel("RSA");
  }
}
