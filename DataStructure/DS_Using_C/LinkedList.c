#include <stdio.h>
#include <stdlib.h>
struct Node
{
    /* data */
    int data;
    struct Node *next;
};
struct Node *head=NULL;
void display(){
    struct Node *temp = head;;
    while (temp!=NULL)
    {
        printf("%d -> ",temp->data);
        temp=temp->next;
    }
    printf("\n");
}
void addfirst(int data){
    struct Node *n  = (struct Node*)malloc(sizeof(struct Node));
    n->data = data;
    n->next =head;
    head=n;
}
void addLast(int data){
    struct Node *n  = (struct Node*)malloc(sizeof(struct Node));
    n->data = data;
    n->next=NULL;
    if(head ==NULL){
        head =n;
        return;
    }
    struct Node* temp = head;
    while (temp->next!=NULL)

    {
        printf("%d\n",temp->data);
            temp=temp->next;
    }
    temp->next= n;
    
    

}

void delFirst(){
    if(head==NULL){
        printf("Empty ");
        return;
    }
    if(head->next==NULL){
        
        head=NULL;

        printf("now list is EMpty\n");
        return;
    }
    head =head->next;

}
void delLast(){
    if(head==NULL){
        printf("Empty ");
        return;
    }
    if(head->next==NULL){
        
        head=NULL;

        printf("now list is EMpty\n");
        return;
    }
    struct Node *temp = head;
    while (temp->next->next!=NULL)
    {
        /* code */
        temp=temp->next;

    }
    free(temp->next);
    temp->next=NULL;
    
}
int main(int argc, char const *argv[])
{

    addfirst(20);
    addLast(30);
    addLast(100);
    delLast();
    delLast();
    delLast();
    delLast();
    display();
    return 0;
}

