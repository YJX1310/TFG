import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;

import org.antlr.v4.runtime.CharStream;

import test.Test1;

public class Test {

	static class TestClassLoader extends ClassLoader {

@Override

public Class<?> loadClass(String name) throws ClassNotFoundException {

if (name.equals("test.Test1")) {

try {

InputStream is = Test.class.getClassLoader().getResourceAsStream("test/Test1.class");

byte[] buf = new byte[1000000];

int len = is.read(buf);

return defineClass(name, buf, 0, len);

} catch (IOException e) {

throw new ClassNotFoundException("", e);

}

}

return getParent().loadClass(name);

}

	}

	public static void main(String[] args) throws Exception {

		for (;;) {

			Class cls = new TestClassLoader().loadClass("test.Test1");
			Constructor constructor = cls.getConstructor(String.class);
			Object obj =  constructor.newInstance("a");

			System.out.println(cls.getMethod("hello").invoke(obj));

			Thread.sleep(5000);

		}

	}
}