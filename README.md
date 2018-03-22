# bytes
java bytes utils

## About
bytes library implements all of string functions for byte arrays<br>
Useful for APIs that work with byte arrays - Saves you from having to convert the bytes to a string

### Examples
concatenate arrays - like ```"abc".concat("def")```
```java
byte[] join = Bytes.concat(new byte[]{1,2,3}, new byte[]{4,5,6}); // join = [1,2,3,4,5,6]
```
<br>

sub array - like ```"abcdef".substring(2)```

```java
byte[] sub = Bytes.subarray(new byte[]{10,20,30,40,50}, 2); // sub = [30,40,50]
```
<br>

And much more, such as `split` `replaceFirst` `replaceAll` `copy` `indexOf` `lastIndexOf` `equal` `startWith` `endWith` ...
<br>
<br>
<br>
<br>
To know the bytes behind a string, just use
```java
byte[] arr = "abcdef".getBytes();
//or even
byte[] arr2 = Bytes.toByte("abcdef");
```
<br>

## To Start Using Maven

```java
<dependency>
    <groupId>urlvnbrg</groupId>
    <artifactId>bytes</artifactId>
    <version>1.0.0</version>
</dependency>
```
