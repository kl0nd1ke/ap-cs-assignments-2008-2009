public class HelloBadIndentation
{
	public boolean badIndentation(int maxLines)
	{
		int lineCount = 3;
		while(lineCount < maxLines)
		{
			System.out.println(lineCount);
			lineCount++;
		}
		return true;
	}
}