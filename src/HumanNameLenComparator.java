import java.util.Comparator;


public class HumanNameLenComparator implements Comparator<Human>{

	@Override
	public int compare(Human o1, Human o2) {
		// TODO Auto-generated method stub
		return o1.getName().length() == o2.getName().length() ? -1 : o1.getName().length()-o2.getName().length();
	}

}
