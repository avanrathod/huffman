
public class huffman {
//dataset d;
heap h=new heap();
void insertInHeap(dataset d[])
{
//	for(int i=0;i<d.length;i++)
//	System.out.println(d[i].s+" "+d[i].i);
	for(int i=0;i<d.length;i++)
		h.insert(d[i]);
}
void combineAndInsert()
{
	dataset a=h.extractMin();
	dataset b=h.extractMin();
	dataset c=new dataset();
	c.i=a.i+b.i;
	//c.s=a.s+b.s;
	c.left=a;
	c.right=b;
	h.insert(c);
}
void print(dataset d,int c[],int n)
{
	if(d.left!=null)
	{
		c[n]=0;
		n++;
		print(d.left,c,n);
		n--;
	}
	if(d.right!=null)
	{
			c[n]=1;
			n++;
			print(d.right,c,n);
			n--;
	}
	if(d.left==null&&d.right==null)
	{
		System.out.print(d.s+"=");
		for(int i=0;i<n;i++)
			System.out.print(c[i]);
		System.out.println();
	}
	n--;
}
public static void main(String[] args)
{
	dataset a[]=new dataset[5];
	a[0]=new dataset();
	a[0].s="A";//value
	a[0].i=24;//frequency
	a[1]=new dataset();
	a[1].s="B";
	a[1].i=12;
	a[2]=new dataset();
	a[2].s="C";
	a[2].i=10;
	a[3]=new dataset();
	a[3].s="D";
	a[3].i=8;
	a[4]=new dataset();
	a[4].s="E";
	a[4].i=8;
	huffman hm=new huffman();
	hm.insertInHeap(a);
	for(int i=0;i<=hm.h.n;i++)
		System.out.println(hm.h.a[i].s+" "+hm.h.a[i].i);
	while(hm.h.n!=0)
		hm.combineAndInsert();
	int c[]=new int[100];
	hm.print(hm.h.extractMin(), c, 0);
	
}
}
