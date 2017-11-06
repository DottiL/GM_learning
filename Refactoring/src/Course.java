package badSmell;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Encapsulate collection.
 * 
 * @author dev
 *
 */
public class Course {
	public Course(String name, boolean isAdvanced) {
	};

	public boolean isAdvanced() {
		return false;
	};

	public static void main(String[] args) {
		ECPerson kent = new ECPerson();
		Set s = new HashSet();
		kent.addCourse(new Course("Smalltalk Programming", false));
		kent.addCourse(new Course("Appreciating Single Malts", true));
		Assert.equals(2, kent.getCourses().size());
		Course refact = new Course("Refactoring", true);
		kent.getCourses().add(refact);
		kent.getCourses().add(new Course("Brutal Sarcasm", false));
		Assert.equals(4, kent.getCourses().size());
		kent.getCourses().remove(refact);
		Assert.equals(3, kent.getCourses().size());

		Iterator iter = kent.getCourses().iterator();
		int count = 0;
		while (iter.hasNext()) {
			Course each = (Course) iter.next();
			if (each.isAdvanced())
				count++;
		}
	}
}

class ECPerson {
	private Set _courses = new HashSet();

	public Set getCourses() {
		return Collections.unmodifiableSet(_courses);
	}

	public void initializeCourses(Set arg) {
		Assert.isTrue(_courses.isEmpty());
		Iterator iter = arg.iterator();
		while (iter.hasNext()) {
			addCourse((Course) iter.next());
		}
	}

	public void addCourse(Course arg) {
		_courses.add(arg);
	}

	public void removeCourse(Course arg) {
		_courses.remove(arg);
	}
}
