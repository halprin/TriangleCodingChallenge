# TriangleCodingChallenge
This Java application is a response to the Developer Coding Challenge by Flexion.

## Install
There are two methods to get the application: without the source or from the source.

### Without Source
This is the easiest way to get the application to run due to less dependencies and not needing to download the source
code.  All that is required is [Docker](https://www.docker.com/).

Download the `runTriangleDocker` Bash script.
```bash
$ curl https://raw.githubusercontent.com/halprin/TriangleCodingChallenge/master/runTriangleDocker > runTriangleDocker
$ chmod +x ./runTriangleDocker
```

```bash
$ wget https://raw.githubusercontent.com/halprin/TriangleCodingChallenge/master/runTriangleDocker
$ chmod +x ./runTriangleDocker
```

Afterward, you can [execute via Docker](#docker-without-source).

### From Source
You can download the source either using the `Download ZIP` button under the `Clone or download` dropdown menu or using
git directly.

```bash
$ git clone https://github.com/halprin/TriangleCodingChallenge.git
$ cd TriangleCodingChallenge
```

Afterward, you can execute via [Docker](#docker-from-source) or [natively](#native-from-source).

## Executing
No matter how you execute the application, you can choose to pass in command line arguments or not.  These arguments are
the lengths of the sides of the triangle.  Only three arguments are required.  If an argument is not a valid number, the
application will try to parse the next argument.  The user is prompted for additional sides if there are insufficient
valid arguments.

### Docker Without Source
[Docker](https://www.docker.com/) must be installed.  This method only runs
[halprin/trianglecodingchallenge](https://hub.docker.com/r/halprin/trianglecodingchallenge/).  The image will be
downloaded first if it has not already.  Therefore, any local changes to source code will not be reflected in the
execution.

Download the `runTriangleDocker` Bash script as [previously mentioned](#without-source) and run it. 

```bash
$ ./runTriangleDocker 1.5 1.5 1.5
equilateral
$ ./runTriangleDocker
Please supply a number for side 1: 3
Please supply a number for side 2: 4
Please supply a number for side 3: 4
isosceles
```

### Docker From Source
[Docker](https://www.docker.com/) must be installed.  This method builds and runs an image from the local source code.
Be sure you downloaded the source code as [previously mentioned](#from-source) and execute the
`runTriangleDockerSource` Bash script.

```bash
$ ./runTriangleDockerSource 1.5 1.5 1.5
equilateral
$ ./runTriangleDockerSource
Please supply a number for side 1: 3
Please supply a number for side 2: 4
Please supply a number for side 3: 4
isosceles
```

### Native From Source
Java and Maven must be installed and be in the `$PATH`.  This method compiles the application from the local source code
first if it has not already.  Be sure you downloaded the source code as [previously mentioned](#from-source) and execute the
`runTriangleNative` Bash script.

```bash
$ ./runTriangleNative 1.5 1.5 1.5
equilateral
$ ./runTriangleNative
Please supply a number for side 1: 3
Please supply a number for side 2: 4
Please supply a number for side 3: 4
isosceles
```
