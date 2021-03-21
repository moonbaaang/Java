# 13장 제네릭

> Generics

1. 내가 사용할 데이터 타입을 미리 알려주고,
2. 컴파일러가 타입을 체크하여
3. 실행 시 발생할 수 있는 잘못된 형변환을 알려준다. (줄여준다.)
   * ArrayList\<A>, HashMap<key,val>, HashSet\<C>에서 모두 사용하는 법이 나와있다.

* 라이브러리 (generic 괄호) \<T> \<K>

</br>

## 왜 제네릭을 사용해야하는가?

### 컴파일 시 강한 타입 체크를 할 수 있다.

* 실행 시 타입 에러가 발생하는 것보다 컴파일 시 에러를 방지하는 게 좋다.

### 타입 변환(casting)을 제거한다.

* Object타입을 사용하면 모든 종류의 객체를 저장할 수 있으나 잦은 형변환이 발생한다는 단점이 있다.

### 제네릭 타입의 상속과 구현

* 제네릭 타입과 관련된 간단한 코드를 작성해보자.

```java
public class Box<T> {
	private T t;
    public void set(T t){this.t = t;}
    public T get(){ return t; }
}

// 예를 들어 다음과 같이 Box 객체를 생성했다고 가정해보자
Box<String> box = new Box<String>();

// 이러면 타입파라미터 T는 모두 String 타입으로 변경되어 Box클래스의 내부는 다음과 같이 자동으로 재구성된다.

public class Box<String> {
	private String t;
    public void set(String t){this.t = t;}
    public String get(){ return t; }
}
```

* 이와같이 제네릭은 클래스를 설계 시 구체적인 타입을 명시하지 않고, 타입 파라미터로 대체한다.
  * 실제 클래스가 사용될 때 구체적인 타입을 지정함으로써 타입 변환을 최소화시킨다.

### 멀티 타입 파라미터

* 제네릭 타입은 두개 이상의 멀티 타입 파라미터를 사용할 수도 있다.
  * 이 경우 각 타입 파라미터를 콤마로 구분한다.

```java
class Apple{
	String origin = "대구";
}
class Paper{
	String size = "A4";
}
class Box<T, K>{ 
	T t1;
	K k1;
	Box(T t1, K k1){
		this.t1 = t1;
		this.k1 = k1;
	}
	public T getT1() { return t1; }
	public K getK1() { return k1; }
	public void setT1(T t1) { this.t1 = t1; }
	public void setK1(K k1) { this.k1 = k1;	}
}

class BoxManager{ 
	public <P1, P2> Box <P1, P2> test(P1 a, P2 p) { 
		Box<P1, P2> box2 = new Box<P1, P2>(a, p);
		return box2;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		Apple a = new Apple();
		Paper p = new Paper();
		Box<Apple, Paper> box = new Box<Apple, Paper>(a, p);
		System.out.println(box.getT1().origin);
		System.out.println(box.getK1().size);
		
		BoxManager manager = new BoxManager();
		Box<Apple, Paper> box2 = manager.test(a, p);
		System.out.println(box2.getT1().origin); 
		System.out.println(box2.getK1().size);
	}
}


// 결과
대구
A4
대구
A4


```

