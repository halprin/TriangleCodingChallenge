# TriangleCodingChallenge
This Java application is a response to the Developer Coding Challenge by Flexion.

## Install
There are two methods to install the application: via Docker or from source.

### Docker
Download the `runDocker` Bash script.
```bash
$ curl https://raw.githubusercontent.com/halprin/TriangleCodingChallenge/master/runDocker > runDocker
$ chmod +x ./runDocker
```

```bash
$ wget https://raw.githubusercontent.com/halprin/TriangleCodingChallenge/master/runDocker
$ chmod +x ./runDocker
```

Afterward, you can execute via Docker.  See Execution, Docker below.

### From Source
You can download the source either using the `Download ZIP` button under the `Clone or download` dropdown menu or using
git directly.

```bash
$ git clone https://github.com/halprin/TriangleCodingChallenge.git
```

Afterward, you can execute via Docker or natively.  See Execution, Docker or Native, below.

## Execution
No matter how you execute the application, you can choose to pass in command line arguments or not.  These arguments are
the lengths of the sides of the triangle.  Only three arguments are required.  If an argument is not a valid number, the
application will try to parse the next argument.  The user is prompted for additional sides if there are insufficient
valid arguments.

### Docker
[Docker](https://www.docker.com/) must be installed for this method to work.  The benefit here is Java and Maven are not
 required.  The image will be downloaded first if it has not already.

```bash
$ ./runDocker [<length of side> ...]
```

### Native
Java and Maven must be installed and be in the `$PATH` for this method to work.  The project will compile first if it
has not already.

```bash
$ ./runNative [<length of side> ...]
```
