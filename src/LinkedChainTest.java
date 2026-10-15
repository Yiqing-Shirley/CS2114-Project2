



// -------------------------------------------------------------------------
/**
 *  Tests the LinkedChain class
 * 
 *  @author Anna-Maria Renalds
 *  @version Oct 15, 2026
 */
public class LinkedChainTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests the add method of the LinkedChain class
     */
    public void testAdd()
    {
        LinkedChain<String> link = new LinkedChain<>();
        assertTrue(link.add("A"));
        assertEquals(1, link.size());
        assertFalse(link.isEmpty());
        assertEquals("A", link.get(0));
        link.add("B");
        assertEquals(2, link.size());
        assertEquals("B", link.get(0));
        assertEquals("A", link.get(1));
        assertEquals("[B, A]", link.toString());
        
        try {
            link.add(null);
            
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Cannot add null to chain", e.getMessage());
        }
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the addToEnd method of the LinkedChain class.
     */
    public void testAddToEnd()
    {
        LinkedChain<String> link = new LinkedChain<>();
        assertTrue(link.addToEnd("A"));
        assertEquals("[A]", link.toString());
        assertTrue(link.addToEnd("B"));
        assertEquals(2, link.size());
        assertEquals("A", link.get(0));
        assertEquals("B", link.get(1));
      
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the remove method of the LinkedChain class
     */
    public void testRemove()
    {
        LinkedChain<String> link = new LinkedChain<>();
        link.addToEnd("A");
        link.addToEnd("B");
        assertEquals("A", link.remove());
        assertEquals(1, link.size());
        assertEquals("B", link.get(0));
        assertEquals("B", link.remove());
        assertTrue(link.isEmpty());
        assertNull(link.remove());
        assertFalse(link.remove("A"));
        assertFalse(link.remove(null));
        link.addToEnd("A");
        link.addToEnd("B");
        link.addToEnd("C");
        link.addToEnd("D");
        assertFalse(link.remove("Z"));
        assertTrue(link.remove("A"));
        assertEquals("[B, C, D]", link.toString());
        assertTrue(link.remove("C"));
        assertEquals("[B, D]", link.toString());
        assertTrue(link.remove("D"));
        assertEquals("[B]", link.toString());
        
        

    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the clear method of the LinkedChain class
     */
    public void testClear()
    {
        LinkedChain<String> link = new LinkedChain<>();
        link.addToEnd("A");
        link.addToEnd("B");
        link.clear();
        assertEquals(0, link.size());
        assertTrue(link.isEmpty());
        assertEquals("[]", link.toString());
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the get method of the LinkedChain class
     */
    public void testGet()
    {
        LinkedChain<String> link = new LinkedChain<>();
        link.addToEnd("A");
        try {
            link.get(-1);
        }
        catch(IndexOutOfBoundsException e)
        {
            //caught
        }
        try {
            link.get(1);
        }
        catch(IndexOutOfBoundsException e){
            //caught
        }
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the contains method of the LinkedChain class
     */
    public void testContains()
    {
        LinkedChain<String> link = new LinkedChain<>();
        assertFalse(link.contains("A"));
        link.addToEnd("A");
        link.addToEnd("B");
        link.addToEnd("A");
        assertTrue(link.contains("A"));
        assertTrue(link.contains("B"));
        assertFalse(link.contains("C"));
        

    }
    
    // ----------------------------------------------------------
    /**
     * Tests the count method of the LinkedChain class
     */
    public void testCount()
    {
        LinkedChain<String> link = new LinkedChain<>();
        assertEquals(0, link.count("A"));
        assertEquals(0, link.count(null));
        link.addToEnd("A");
        link.addToEnd("B");
        link.addToEnd("A");
        assertEquals(2, link.count("A"));
        assertEquals(1, link.count("B"));
        assertEquals(0, link.count("C"));
    }
    
    // ----------------------------------------------------------
    /**
     * Tests the toArray method of the LinkedChain class
     */
    public void testToArray()
    {
        LinkedChain<String> link = new LinkedChain<>();
        link.addToEnd("A");
        link.addToEnd("B");
        String[] template = new String[2];
        String[] finale = link.toArray(template);
        assertEquals(template, finale);
        assertEquals("A", finale[0]);
        assertEquals("B", finale[1]);
        
        try {
            link.toArray(null);
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Array must not be null", e.getMessage());
        }
        
        try {
            link.toArray(new String[1]);
        }
        catch(IllegalArgumentException e)
        {
            assertTrue((e.getMessage().contains("too small")));
        }
    }

}
