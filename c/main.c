#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_INP 64 // realistically the float will not be longer than that.

struct Array {
    float* points;
    int size;
} array; // make struct and variable of Array called array

int add_point(float num) {
    array.size++; // increment the size
    array.points = realloc(array.points, array.size*sizeof(float)); // reallocate the array as one larger
    array.points[array.size-1] = num; // set the last value of the array to the new num
}

void init_array(){
    // initialise the array size and contents
    array.size = 0;
    array.points = (float*) malloc(0);
}

void reset_array(){
    // reset the array to the starting size and delete the contents of the array.
    array.size = 0;
    array.points = (float*) realloc(array.points, 0);
}

void free_array(){
    free(array.points);
}

void input_data(){
    while(1){
        char data[MAX_INP];
        
        printf("=> "); // prompt
        scanf("%s", data); // read the variable in

        if(data[0] == 'c' || data[0] == 'C'){
            break;
        }
        
        add_point(atof(data)); // add the point as the float value of data
    }
}

float sum_array(){
    float out=0;
    
    for(int i=0 ; i<array.size ; i++){
        out += array.points[i]; // keep adding the point to find total
    }
    
    return out;
}



float get_avg(){
    if(array.size == 0){ // no contents of array
        return 0;
    }
    return sum_array() / array.size; // divide total by sum of array
}


int main_avg(){
    init_array(); // initialise array

    printf("Simply write each number on a newline, and enter 'c' to calculate.\n");

    input_data(); // get the data
    
    float avg = get_avg(); // output the average
    printf("Average: %f\n", avg);

    char again[1]; // array to store the data in
    printf("Again? [y/n]: "); // print the prompt
    scanf("%s", again); // copy user input to again var

    if(again[0] == 'y' || again[0] == 'Y'){ // if variable is y
        return 1; // repeat
    }
    return 0; // do not repeat
}

int main(){
    while(main_avg()){ reset_array(); }

    free_array();

    return 0;
}
