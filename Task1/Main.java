public class Main{
	public static void main(String[] args){
		Persister persister = new Persister();
		Report report = new Report();
		User user = new User("Bob");
		persister.save(user);
		report.report(user);

	}
}