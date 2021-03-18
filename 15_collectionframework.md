# 15. 컬렉션 프레임워크

> Collection Framework

* 배열

  * 여러가지 데이터를 저장할 수 있는 구조이다.
    * ex) int i [] = new int[50];
* 배열의 한계점
  1. 배열은 동일 타입 데이터만 저장이 가능한 구조이다.
     * 형변환이 가능하면 동일타입으로 간주한다.
  2. i = new int [100];
     * 기존 50개 배열의 주소는 없어지고 100개짜리 배열을 생성하고 그 배열의 주소를 참조한다.
     * 배열의 크기는 정적으로 관리된다.
     * 배열을 삭제했을 때 해당 인덱스가 비게된다.
* 개선 방법

  * java.util 패키지에 있는 컬렉션 프레임워크
    * 배열이 가지고 있던 한계점을 개선할 수 있는 데이터 저장 구조 클래스이다.
      1. 여러가지 타입 + 동일 타입을 저장할 수 있어 타입에 제약이 없다.
      2. 배열의 크기는 동적으로 변경이 가능하다.
      3. 자바 틀 - 순서대로 관리할 수 있도록 / 순서 없이 관리할 것인가?, 값만 저장할 것인가,  키와 값의 한쌍을 저장할 것인가?, 중복 데이터를 저장할 것인가?
* Collection Framework는 위와같은 단점을 해결해준다.

### java.util.List 인터페이스

* 메소드로 구현된 것이 아무것도 없다.

* 클래스로 다중상속, 메소드 오버라이딩을 구현해야한다.

* ex) ArrayList, LinkedList, Vector, Stack 클래스들

* 데이터 관리 시 **순서를 가지고** 데이터를 관리한다. 

  1. 인덱스를 사용가능하다.

  2. 같은 데이터를 중복하여 저장하는 것을 허용한다.
     * ex) add(); 가 있으면 오버라이딩하여 사용한다.

### java.util.Set 인터페이스

* 메소드 구현된 것이 아무것도 없다.
* 클래스로 다중상속, 메소드 오버라이딩을 구현해야한다.
* **순서없이** 데이터를 관리한다.
  1. 인덱스를 사용할 수 없다.
  2. 같은 데이터를 중복하여 저장할 수 없다. (ex) 로또
     * add();를 가지고 HashSet, TreeSet 클래스 등 > 검색속도가 빠르다.

### java.util.Map 인터페이스

* 메소드 구현된 것이 아무것도 없다.
* 클래스로 다중상속, 메소드 오버라이딩을 구현해야한다.
* 데이터 하나가 **(키, 값)** 한 쌍이다.
  1. 키는 중복될 수 없다.
  2. 값은 중복가능하다.
     * HashMap, Hashtable, Properties 등

</br>

## 간단하게 다시 정리해보았다.

##### List 

* 데이터 = 값
* 순서가 있다.
* 중복데이터를 허용한다.
  * ArrayList

##### Set

* 데이터 = 값
* 순서가 없다. (인덱스가 없다.)
* 중복데이터를 허용하지 않는다.
  * HashSet

##### Map

* 데이터 = (키,값)
* 키는 중복 불가능하다.
* 값은 중복을 허용한다.
* 순서가 없다.
  * Hashmap

##### 공통점

* 여러가지 데이터 타입을 저장 가능하다.
* 동적으로 크기를 변경할 수 있다.

> p. 723 그림 참조

##### 배열과의 차이점

* 배열은 기본형 변수와 참조형 변수를 모두 저장 가능하다.
* 하지만 컬렉션 프레임워크는 참조형 데이터만 저장한다.
  * 그럼 정수, 실수는 기본형 변수인데 어떻게 저장하는 것인지?
    * int/double >> Integer 클래스 / Double 클래스를 이용하여 저장가능

</br>

### ArrayList

* 생성자
  * 배열의 경우 int i [] = new int [50]; > 정적인 크기로 유지된다.

  * 하지만 List의 경우 동적으로 크기를 관리할 수 있다.

    ```java
    import java.util.ArrayList;
    ArrayList list = new ArrayList();
    ```

    * 여러가지 객체 유형이 저장 가능하기 때문에 크기나 타입에 대한 정보를 나타내지 않는다.
    * 최초에 10개 객체를 저장할 수 있는 ArrayList()를 생성한다.
    * 이후 데이터를 저장할 수 있는 공간이 없을 경우 자동으로 10개씩 증가한다.

    ```java
    ArrayList list = new ArrayList(5); 
    // 최초 5개 객체, 이후 동적으로 5개씩 증가
    ArrayList list = new ArrayList(5,3);
    // 최초 5개 객체, 이후 동적으로 3개씩 증가
    ```
* 메소드 - List인터페이스를 상속받아 오버라이딩한다.
  * 저장
    * add(객체)
      * 매개변수 타입은 Object o(모든 타입) 또는add(int index, Object o) 정의
        * add는 가장 뒤에 삽입
        * insertAt은 지정된 위치에 삽입

    ```java
    list.add(100);
    list.add(3.14);
    list.add("aaa");
    ```

    * 기본형 타입은 안된다고 하지 않았는지?
      * int기본형 = Integer 클래스로 표현된 것으로 간주한다.
      * double기본형 = Double 타입의 객체로 표현된 것으로 간주
    * addElement()
    * addObject

  * 수정

    ```java
    list.set(index,"__edit__");
    ```

  * 삭제

    ```java
    list.remove(index);
    list.remove("data");
    ```

  * 조회
    * 데이터의 갯수를 조회

    ```java
    // 배열의 경우 배열.length
    list.size();
    ```

    * 데이터 저장여부 조회

    ```java 
    list.contains("data");
    // 이는 boolean 타입을 반환한다.
    ```

    * 데이터 저장위치 조회

    ```java
    list.indexOf("java");
    // int 타입의 index 값을 반환한다.
    // index 값은 항상 0 이상
    ```

    * 특정위치 저장데이터 조회

    ```java
    list.get(index);
    //Object 타입을 반환한다.
    ```

  * 그 외

    * LinkedList, Vector

</br>

* ArrayList 관련 간단한 코드를 작성해보았다.

```java
import java.util.ArrayList;

class Employee{
	int id;
	String name;
	double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
    }
    public String toString() {
		return id + "-" + name + "-" + salary;
	}	
}
public class ArrayListTest {
	public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<Employee>(5);
        // <Employee> 클래스만 접근 가능하도록 generic 타입을 설정하였다.
        Employee e1 = new Employee(100, "이사원", 56000.55);
		Employee e2 = new Employee(200, "최대리", 66000.55);
		Employee e3 = new Employee(300, "박과장", 76000.55);
        list.add(e1);
		list.add(e2);
		list.add(e3);
        System.out.println(list.size()); 
        // 이때 5를 반환하지 않고 데이터가 저장된 갯수인 3을 반환한다.
        
        // list내에 "이회장" 문자열이 있다면 해당 문자열의 위치를 확인하고 삭제한다.
        if(list.contains("이회장")) {
			System.out.println(list.indexOf("이회장"));
			list.remove("이회장");			
		}
        for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			System.out.println(i+" 번 인덱스 = "+o);
            
        if (o instanceof Employee) {
				System.out.println(((Employee)o).name);
        }
            // o 객체가 Employee로 형변환이 가능한지 확인
    }
}
    
// 결과
3
0 번 인덱스 = 100-이사원-56000.55
이사원
1 번 인덱스 = 200-최대리-66000.55
최대리
2 번 인덱스 = 300-박과장-76000.55
박과장
```

</br>

### HashSet

```java
import java.util.HashSet;
```

* 순서가 없기 때문에 수정하는 기능은 없다.
* add(); 

```java
add("a");
add("b");
add("a");
```

- 이때 세번째 add 는 실행이 되지 않는다. 
  - 단, 오류는 발생하지 않는다.

* iterator() -> 저장 데이터를 모아둔다.

```java
import java.util.Iterator;
```

* 저장 순서는 일치하지 않는다.

```java
HashSet set = new HashSet();
```

* 길이는 list와 같이 동적으로 유지된다.
* 여러 데이터를 저장 가능하다.

```java
HashSet<A> set = new HashSet<A>();
```

* 이때 \<A>는 generic 타입

* 길이는 동적으로 유지된다.
* 동일 타입 데이터(A)만을 저장 가능하다.

</br>

* HashSet관련 간단한 코드를 작성해 보았다.

```java
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<Employee>();
        // 이때 <Employee> 메소드는 ArrayList에 정의되어있다.
        Employee e1 = new Employee(400, "박부장", 88000.99);
        set.add(e1);
		set.add(e1); // 중복저장이므로 무시된다.
        System.out.println(set.size()); // 1을 반환한다.
        
        Iterator<Employee> it = set.iterator();
        while(it.hasNext()) { // hasNext() 다음 데이터가 존재하는지 조회한다.
            Employee o = it.next(); 
            System.out.println(o.name); // name객체만 print한다.
        }
        
// 결과
1
박부장
```

```java
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
        HashSet<Integer> lotto = new HashSet<Integer>();
        	while(true) {
				int number = (int)(Math.random()*45)+1;
				lotto.add(number);
				if(lotto.size() == 6 ) {break;}
			}
			Iterator<Integer> it2 = lotto.iterator();
			while(it2.hasNext()) {
				System.out.println(it2.next());	
			}
/*     	    for(Integer one : lotto) {
			// for문의 다른 사용법, 동일한 결과를 나타낸다.
                System.out.println(one);	
            }
*/
      }
}

//결과
3
35
25
11
27
14
```

</br>

### HashMap

```java
import java.util.HashMap;
```

* 키와 값의 한 쌍으로 구성된 형태이다.
* 키는 중복될 수 없고 값은 중복될 수 있다.

```java
HashMap map = new HashMap();
HashMap<키 타입지정, 값 타입지정> map = new HashMap();
HashMap<키 타입지정, 값 타입지정> map = new HashMap<키 타입지정, 값 타입지정>();
```

* 이렇게 generic 타입을 이용한 세가지 형태로 사용된다.	
  * list set 도 동일하나 데이터타입은 하나만 지정하면 된다.

```java
// 다음과 같이 설정했다고 하자.
HashMap<String, Integer> map = new HashMap();
map.put("id",200);
map.put("score", 100);
map.put("score", 300); // 이는 새로 추가되지 않고 score키의 값을 수정한다.

map.get("id"); // map 또한 순서가 상관이 없다.
map.size();
```

* Key (String)									Value (String[])

| 초등친구 | 폰, 집, 사무실, 이메일 |
| -------- | :--------------------- |
| 고등친구 | 폰, 집, 사무실, 이메일 |
| 회사동기 | 폰, 집, 이메일         |
| 회사상사 | 폰, 이메일             |

* 관련 코드를 작성해보았다.

```java
import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {
	public static void main(String[] args) {
        HashMap<String, String[]> phone = 
				new HashMap<String, String[]>();
        phone.put("초등친구", new String [] {"010-3123-1323", "02-3432-0412", 
				"031-3231-5213",  "fri1@multi.com"});
        phone.put("고등친구", new String [] {"010-1111-2222", "02-3432-0862", 
				"031-3231-5098",  "fri2@multi.com"});
		phone.put("회사동기", new String [] {"010-1991-2341", "02-3431-1365", 				  "fri3@multi.com"});
		phone.put("회사상사", new String [] {"010-9988-8888", 								"fri4@multi.com"});
		System.out.println("총연락처 갯수 = " + phone.size());
        
        if(phone.containsKey("회사동기")) {
			String[] phonelist1 = phone.get("회사동기"); 
            // 회사동기 키의 값들을 리스트로 불러온다.
			for(String one : phonelist1) {
				System.out.println(one);
			}
        }
        if(phone.containsKey("사장님")) { 
			String[] phonelist2 = phone.get("사장님");
			for(String one : phonelist2) {
				System.out.println(one);
			} 
		} else 
        	{
				System.out.println("사장님 연락처는 없습니다.");
			}
    
        Set<String> keys = phone.keySet(); //key값을 Set으로 변환시켜준다.
		for(String k : keys) {
			String [] phonelist = phone.get(k);
			for(String one: phonelist) {
				System.out.print(one + " | ");
			}
			System.out.println();
   			}
      }
}

// 결과
총연락처 갯수 = 4
010-1991-2341
02-3431-1365
fri3@multi.com
사장님 연락처는 없습니다.
010-1111-2222 | 02-3432-0862 | 031-3231-5098 | fri2@multi.com | 
010-1991-2341 | 02-3431-1365 | fri3@multi.com | 
010-9988-8888 | fri4@multi.com | 
010-3123-1323 | 02-3432-0412 | 031-3231-5213 | fri1@multi.com | 
```

* HashMap과는 관련이 없을 수 있으나 배열에 관한 코드 하나를 살펴본다.

```java
String [] s1 = new String[3];
s1[0] = "010-1234-5678";
s1[1] = "02-3432-1293";
s1[2] = "ss@multi.com";
        
String [] s2 = {"010-1234-5678","02-3432-1293","ss@multi.com"};
// 이때 s1과 s2의 결과는 같다. (s2는 일반적으로 json형태)
```

