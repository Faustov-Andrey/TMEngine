package webRequestListener;

public class WebRequestListener {
		//������� ��������� �������
		public static int mTreadCounter = 0;
		
		static ListenerThread mListenThread;
		static ListenerThread mLTArray[];	//������ �������� �������
		
		
			
		public static void main(String[] arg) {
			
			ListenerThread mLTArray[] = new ListenerThread[10];
			
			// ���� ���������� �������
			for(int i = 0; i < 4; i++)
			{	
				mLTArray[i] = new ListenerThread();	//�������� i-������ 
				System.out.println("� main, �������� ����� � " + i + "   ");
				mLTArray[i].start();	//������ i-�� ������
			}

			// ���������� ������� � ������ � 3 ���
			for(int j = 0; j < 4; j++)
			{
						
				try{
					Thread.sleep(3000);	
					System.out.println("main thread sleep ");
					mLTArray[j].interrupt(); //���������� j-�� ������
					System.out.println("� main, �������� ����� � " + j + "   ");
				}catch(InterruptedException e){
					System.out.println(e);
					return;	//���������� ������ ����� ����������
				}
			}
		}
}


class ListenerThread extends Thread
{

	@Override
	public void run()
	{
		
		System.out.println("� ����� " + this.toString() + ", � ����������  ");
		
		do
		{
			if(!Thread.interrupted())	//�������� ����������
			{
				//����� ��������� ����������� ������
				System.out.println("� ����� " + this.toString() + ", � �������  ");								
			}
			else
				return;		//���������� ������	

			try{
				Thread.sleep(1000);		//������������ ������ �� 1 ���.
			}catch(InterruptedException e){
				return;	//���������� ������ ����� ����������
			}
		}
		while(true); 
	}
}

