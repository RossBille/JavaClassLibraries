JavaClassLibraries
==================
Used to store my commonly used java classes

Currently consisting of implementations of Either and Both with a Helper class to aid in using these classes

See http://rossbille.github.io/JavaClassLibraries/ for documentation

prerequisites
------
JDK 1.8

Build
------
Project can be built with Maven with the view to have it submitted to a central repository.
For now just run `mvn install` after a `git clone` to install to your local Maven repository

Examples
------
Instead of:

	public String getString(String var){
		if(var == null){
			throw new IllegalAccessException("expected String value");
		}
		...
		return var + var;
	}

	public void stringMethod(){
		String str = getString(null);
		System.out.println(str);
		//IllegalAccessException is thrown
	}
	
Use:

	public Either<IllegalAccessException,String> getString(String var){
		if(var == null){
			return Either.left(new IllegalAccessException("expected String value");
		}
		...
		return Either.right(var + var);
	}

	public void stringMethod(){
		String str = getString(null).match(
			(IllegalAccessException e) -> {return "No string"},
			(String str) -> {return str});
		System.out.println(str);
	}

Thus enforcing the user to think about the exceptional case
