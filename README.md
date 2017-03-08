# TriangleCodingChallenge
This Java application is a response to the Developer Coding Challenge by Flexion.

## Install
There are two methods to install the application: via Docker or from source.

### Docker
Download the `runTriangleDocker` Bash script.
```bash
$ curl https://raw.githubusercontent.com/halprin/TriangleCodingChallenge/master/runTriangleDocker > runTriangleDocker
$ chmod +x ./runTriangleDocker
```

```bash
$ wget https://raw.githubusercontent.com/halprin/TriangleCodingChallenge/master/runTriangleDocker
$ chmod +x ./runTriangleDocker
```

Afterward, you can execute via Docker.  See Execution, Docker below.

### From Source
You can download the source either using the `Download ZIP` button under the `Clone or download` dropdown menu or using
git directly.

```bash
$ git clone https://github.com/halprin/TriangleCodingChallenge.git
$ cd TriangleCodingChallenge
$ chmod +x ./runTriangleDocker
$ chmod +x ./runTriangleNative
```

Afterward, you can execute via Docker or natively.  See Execution, Docker or Native, below.

## Execution
No matter how you execute the application, you can choose to pass in command line arguments or not.  These arguments are
the lengths of the sides of the triangle.  Only three arguments are required.  If an argument is not a valid number, the
application will try to parse the next argument.  The user is prompted for additional sides if there are insufficient
valid arguments.

### Docker
[Docker](https://www.docker.com/) must be installed for this method to work.  The benefit is Java and Maven are not
required.  The image will be downloaded first if it has not already.

```bash
$ ./runTriangleDocker 1.5 1.5 1.5
equilateral
$ ./runTriangleDocker
Please supply a number for side 1: 3
Please supply a number for side 2: 4
Please supply a number for side 3: 4
isosceles
```

### Native
Java and Maven must be installed and be in the `$PATH` for this method to work.  The project will compile first if it
has not already.

```bash
$ ./runTriangleNative 1.5 1.5 1.5
equilateral
$ ./runTriangleNative
Please supply a number for side 1: 3
Please supply a number for side 2: 4
Please supply a number for side 3: 4
isosceles
```
