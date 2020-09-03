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

void input_data(){
    while(1){
        float in;
        
        if(in == -1){
            break;
        }
        
        printf("=> ");
        scanf("%f", &in);
        add_point(in);
    }
}

int main(){
    init_array();
    
    input_data();
    
    print_array();

    return 0;
}
