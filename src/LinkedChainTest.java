



public class LinkedChainTest extends student.TestCase
{
    public void testAdd()
    {
        LinkedChain<String> link = new LinkedChain<>();;
        assertTrue(link.add("A"));
        assertEquals(1, link.size());
        assertFalse(link.isEmpty());
        assertEquals("A", link.get(0));
        link.add("B");
        assertEquals(2, link.size());
        assertEquals("A", link.get(1));
        assertEquals("[B, A]", link.toString());
 
    }
    
    public void testAddToEnd()
    {
        LinkedChain<String> link = new LinkedChain<>();
        assertTrue(link.addToEnd("A"));
        assertTrue(link.addToEnd("B"));
        assertEquals(2, link.size());
        assertEquals("A", link.get(0));
        assertEquals("B", link.get(1));
        assertEquals("[A,B]", link.toString());
    }
    
    public void testRemove()
    {
        LinkedChain<String> link = new LinkedChain<>();
        link.add("A");
        link.add("B");
        assertEquals("A", link.remove());
        assertEquals(1, link.size());
        assertEquals("B", link.get(0));
        assertEquals("B", link.remove());
        assertTrue(link.isEmpty());
        assertFalse(link.remove("A"));
        assertFalse(link.remove((String)(null)));
        link.addToEnd("A");
        link.addToEnd("B");
        link.addToEnd("C");
        link.addToEnd("D");
        assertTrue(link.remove("B"));
        assertEquals("[A, C, B]", link.toString());
        assertEquals(3, link.size());
        assertTrue(link.remove("B"));
        assertEquals("[C,B]", link.toString());
        assertTrue(link.remove("B"));
        assertEquals("[C]", link.toString());
        assertFalse(link.remove("Z"));
    }
    
    public void testCount()
    {
        LinkedChain<String> link = new LinkedChain<>();
        assertFalse(link.contains("A"));
        assertEquals(0, link.count("A"));
        assertEquals(0, link.count(null));
        link.addToEnd("A");
        link.addToEnd("B");
        link.addToEnd("C");
        assertTrue(link.contains("A"));
        assertTrue(link.contains("B"));
        assertTrue(link.contains("C"));
        assertEquals(2, link.count("A"));
        assertEquals(1, link.count("B"));
    }

    public void testToArray()
    {
        LinkedChain<String> link = new LinkedChain<>();
        link.addToEnd("A");
        link.addToEnd("B");
        String[] target = new String[2];
        String[] finall = link.toArray(target);
        assertSame(target, finall);
        assertEquals("A", finall[0]);
        assertEquals("B", finall[1]);
        
    }

}
