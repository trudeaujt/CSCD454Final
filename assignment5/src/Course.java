import java.util.Iterator;

/*
 * Implementation of Iterator
 * Adam Bortfeld 
 * Assignment 5 
 * CSCD 454 
 * Summer 2013
 */
public class Course implements Iterable<Student> {

	/*Nested Iterator Class
	 * ---------------------------------------------------------------------------- */
	
	public class CourseIterator implements Iterator<Student>{
		private Student[] ara;
		private int currIndex;

		public CourseIterator(Student[] ara){
			this.ara = ara;
			currIndex = 0;
		}
		public boolean hasNext(){
			return currIndex < ara.length; 
		}
		public Student next(){
			Student st = ara[currIndex];
			currIndex++;
			return st;
		}
		public void remove(){

		}

	}
/*	End nested Iterator Class
 * ---------------------------------------------------------------------------
 */
	private Student[] iter_ara;
	public Course(Student[] ara){
		this.iter_ara = ara;

	}

	@Override
	public Iterator<Student> iterator() {
		return new CourseIterator(iter_ara);
	}

}
