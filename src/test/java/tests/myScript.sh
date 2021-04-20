#!/bin/bash
mkdir myFolder
cd myFolder
for i in {1..7}; do touch testFile${i}.txt; done
rm -v $(ls -t testFile*.txt | tail -n +4)
ls -t
for filename in *.txt; do
    NUMBER=$(echo "$filename" | grep -o -E '[0-9]+')
    echo -e "I'm file $NUMBER" > $filename; cat $filename;
done