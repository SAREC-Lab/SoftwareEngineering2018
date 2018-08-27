package edu.nd.se2018.homework.hwk1;
import org.junit.Test;

public class Question2Test {

	@Test
	public void test() {
		Question2 question = new Question2();
		String inputString = "macavitys a mystery cat hes called the hidden paw for hes the master criminal who can defy the law hes the bafflement of scotland yard the flying squads despair for when they reach the scene of crime macavity is not there macavity macavity theres no one like macavity hes broken every human law he breaks the law of gravity his powers of levitation would make a fakir stare and when you reach the scene of crime macavity is not there you may seek him in the basement you may look up in the air but I tell you once and once again macavitys not there";
		String inputString2 = "the ideal architect should be a man of letters a skillful draftsman a mathematician familiar with historical studies a diligent student of philosophy acquainted with music not ignorant of medicine learned in the responses of jurisconsults familiar with astronomy and astronomical calculations";
		String inputString3 = "giraffe elephant giraffe tiger tiger";
		String stopWords = "and a hes the of up but with";

		assert(question.getMostFrequentWord(inputString, stopWords).equals("macavity"));
		assert(question.getMostFrequentWord(inputString2, stopWords).equals("familiar"));
		assert(question.getMostFrequentWord(inputString3, stopWords)== null);
		
	}

}
