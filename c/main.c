/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <malloc.h>

struct Array {
    float* points;
    int size;
} array;

int add_point(float num) {
    array.size++;
    array.points = realloc(array.points, array.size*sizeof(float));
    array.points[array.size-1] = num;
}

void init_array(){
    array.size = 0;
    array.points = (float*) malloc(0*sizeof(float));
}

void print_array(){
    for(int i=0 ; i<array.size ; i++){
        printf("Item: %f\n", array.points[i]);
    }
}

int main(){
    init_array();
    
    add_point(1);
    add_point(10);
    add_point(55);
    
    print_array();

    return 0;
}
