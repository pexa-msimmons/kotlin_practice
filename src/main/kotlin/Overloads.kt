// --- Arithmetic operator overloads ---

/*
+ --> plus
- --> minus
* --> times
/ --> div
a % b --> mod
+= =--> plusAssign
 */

data class Point(var x: Int, var y: Int, var z: Int) {
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y, z + other.z)

    operator fun plusAssign(other: Point) {
        x += other.x
        y += other.y
        z += other.z
    }

    operator fun times(scale: Int): Point = Point(x * scale, y * scale, z * scale)
}

// --- Unary operator overloads ---

/*
+a --> unaryPlus
-a --> unaryMinus
!a --> not
++a, a++ --> inc
--a, a-- --> dec
 */

operator fun Point.unaryMinus() = Point(-x, -y, -z)

// --- Comparison operator overloads ---

/*
a > b --> a.compareTo(b) > 0
a < b --> a.compareTo(b) < 0
a >= b --> a.compareTo(b) >= 0
a <= b --> a.compareTo(b) <= 0
a == b --> a.equals(b)
 */

// --- Indexing operator overloading ---

/*
x[a, b] --> x.get(a, b)
x[a, b] = c --> x.set(a, b, c)
 */

// --- Range operator overloading ---

/*
start..end --> start.rangeTo(end)
 */

// --- Test ---

fun overloadExamples() {
    val point1 = Point(1,1,1)
    val point2 = Point(2,2,2)
    val point3 = point1 + point2
    val point4 = point1 * 5
    println(point3)
    println(point4)

    val point5 = -point1
    println(point5)

    point1 += point2
    println(point1 == point3)
}