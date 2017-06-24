/*******************************************************************************
 * Copyright 2012 UPM, http://www.upm.es
 Universidad Politécnica de Madrid
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
package org.universAAL.ontology.questionnaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.universAAL.middleware.owl.ManagedIndividual;

/**
 * This class describes the concept of Answer, its properties and its associated
 * methods.
 *
 * @author mdelafuente
 *
 */
public class Answer extends ManagedIndividual {

	// NAMESPACE & PROPERTIES

	public static final String MY_URI = QuestionnaireOntology.NAMESPACE + "Answer";
	public static final String PROP_ANSWER_CONTENT = QuestionnaireOntology.NAMESPACE + "answerContent";
	public static final String PROP_IS_ASSOCIATED_TO_A_QUESTION = QuestionnaireOntology.NAMESPACE
			+ "isAssociatedToAQuestion";

	public static final int CORRECT_ANSWER = 0;
	public static final int INCORRECT_ANSWER = 1;
	public static final int NO_CORRECT_ANSWER = 2;

	// CONSTRUCTORS
	public Answer() {
		super();
	}

	public Answer(String uri) {
		super(uri);
	}

	public Answer(Object content, Question associatedQuestion) {
		this.addAnswerContent(content);
		this.setAssociatedQuestion(associatedQuestion);
	}

	public Answer(Object[] content, Question associatedQuestion) {
		this.setAnswerContent(content);
		this.setAssociatedQuestion(associatedQuestion);
	}

	public String getClassURI() {
		return MY_URI;
	}

	public int getPropSerializationType(String arg0) {
		return PROP_SERIALIZATION_FULL;
	}

	public boolean isWellFormed() {
		return true && props.containsKey(PROP_ANSWER_CONTENT) && props.containsKey(PROP_IS_ASSOCIATED_TO_A_QUESTION);
	}

	// GETTERS AND SETTERS

	/**
	 * The following method gets the associated question to an answer. The name
	 * automatically-generated by the modeling tool has been changed to be
	 * clearer, from "getIsAssociatedToAQuestion" to "getAssociatedQuestion"
	 *
	 * @return the associated question
	 * @see Question
	 */
	public Question getAssociatedQuestion() {
		return (Question) props.get(PROP_IS_ASSOCIATED_TO_A_QUESTION);
	}

	/**
	 * The following method sets the associated question to an answer. The name
	 * automatically-generated by the modeling tool has been changed to be
	 * clearer, from "setIsAssociatedToAQuestion" to "setAssociatedQuestion"
	 *
	 * @param the
	 *            associated question
	 * @see Question
	 */
	public void setAssociatedQuestion(Question question) {
		if (question != null)
			props.put(PROP_IS_ASSOCIATED_TO_A_QUESTION, question);
	}

	/**
	 * The following method gets the content of an answer. This content can
	 * consist in one resource or more.
	 *
	 * @return the answer's content ({@link Object})
	 */

	public Object[] getAnswerContent() {

		Object propList = props.get(PROP_ANSWER_CONTENT);
		if (propList instanceof List) {
			return (Object[]) ((List) propList).toArray(new Object[0]);
		} else {
			List returnList = new ArrayList();
			if (propList != null)
				returnList.add((Object) propList);
			return (Object[]) returnList.toArray(new Object[0]);
		}
	}

	/**
	 * The following method sets the content of an answer, when the answer
	 * consists of one resource.
	 *
	 * @param the
	 *            answer's content ({@link Object})
	 */

	public void addAnswerContent(Object content) {
		if (content != null)
			props.put(PROP_ANSWER_CONTENT, content);
	}

	/**
	 * The following method sets the content of an answer when the answer
	 * consists of more than one resource, such as in multi-choice questions.
	 *
	 * @param the
	 *            answer's content ({@link Object})
	 */

	public void setAnswerContent(Object[] content) {
		List propList = new ArrayList(content.length);
		for (int i = 0; i < content.length; i++) {
			propList.add(content[i]);
		}
		props.put(PROP_ANSWER_CONTENT, propList);
	}

	// OTHER METHODS
	/**
	 * The following method checks if an answer is correct by comparing it with
	 * the correct answer expected.
	 *
	 * @return true if the question is correct
	 * @return false if the question is NOT correct
	 * @return null if the question is has not correct-answer associated
	 */

	/*
	 * public Boolean isCorrectAnswer(){
	 *
	 * Question associatedQuestion = getAssociatedQuestion();
	 *
	 * if(!associatedQuestion.isHasCorrectAnswer()) //if the question has no
	 * correct answer return null;
	 *
	 * Object[] correctAnswers = associatedQuestion.getCorrectAnswers();
	 * Object[] answerContent = getAnswerContent(); Set <Object>
	 * correctAnswersSet = new HashSet <Object> (Arrays.asList(correctAnswers));
	 * Set <Object> answerContentSet = new HashSet <Object>
	 * (Arrays.asList(answerContent));
	 *
	 *
	 * boolean condition = answerContentSet.containsAll(correctAnswersSet) &&
	 * correctAnswersSet.containsAll(answerContentSet); return condition; }
	 */

	public int isCorrectAnswer() {

		Question associatedQuestion = getAssociatedQuestion();

		if (!associatedQuestion.isHasCorrectAnswer()) // if the question has no
			// correct answer
			return NO_CORRECT_ANSWER;

		Object[] correctAnswers = associatedQuestion.getCorrectAnswers();
		Object[] answerContent = getAnswerContent();
		Set correctAnswersSet = new HashSet(Arrays.asList(correctAnswers));
		Set answerContentSet = new HashSet(Arrays.asList(answerContent));

		boolean condition = answerContentSet.containsAll(correctAnswersSet)
				&& correctAnswersSet.containsAll(answerContentSet);
		if (condition == true)
			return CORRECT_ANSWER;
		else
			return INCORRECT_ANSWER;
	}
}
