# Create your grading script here

rm -rf student-submission
git clone $1 student-submission
cd student-submission

GRADE=0

if [[ -f ListExamples.java ]]; then
  echo "file found"
else
  echo "ListExamples.java file not found"
  echo "Grade: "$GRADE
  exit
fi

cd ~
cp TestListExamples.java student-submission
cp -r lib student-submission
cd student-submission

javac -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar *.java

if [[ $? -ne 0 ]]; then
  echo "Compilation failed"
  echo "Grade: "$GRADE
  exit
fi

java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > passed.txt       

cat passed.txt

RESULT=`grep -c "OK (4 tests)" passed.txt`
if [[ $RESULT -eq 1 ]]; then
        GRADE=4
        echo "Grade: "$GRADE" out of 4"
        exit
fi

RESULT=`grep -c "Tests run: 4,  Failures: 1" passed.txt`
if [[ $RESULT -eq 1 ]]; then
        GRADE=3
        echo "Grade: "$GRADE" out of 4"
        exit
fi

RESULT=`grep -c "Tests run: 4,  Failures: 2" passed.txt`
if [[ $RESULT -eq 1 ]]; then
        GRADE=2
        echo "Grade: "$GRADE" out of 4"
        exit
fi

RESULT=`grep -c "Tests run: 4,  Failures: 3" passed.txt`
if [[ $RESULT -eq 1 ]]; then
        GRADE=1
        echo "Grade: "$GRADE" out of 4"
        exit
fi

RESULT=`grep -c "Tests run: 4,  Failures: 4" passed.txt`
if [[ $RESULT -eq 1 ]]; then
        GRADE=0
        echo "Grade: "$GRADE" out of 4"
        exit
fi