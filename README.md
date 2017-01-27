XML Transformation  using JAXB


input file:

<?xml version="1.0"?>
<catalog>
   <book id="bk101">
      <author>Gambardella, Matthew</author>
      <title>XML Developer's Guide</title>
      <genre>Computer</genre>
      <price>44.95</price>
      <publish_date>2000-10-01</publish_date>
      <description>An in-depth look at creating applications 
      with XML.</description>
   </book>
   <book id="bk102">
      <author>Ralls, Kim</author>
      <title>Midnight Rain</title>
      <genre>Fantasy</genre>
      <price>5.95</price>
      <publish_date>2000-12-16</publish_date>
      <description>A former architect battles corporate zombies, 
      an evil sorceress, and her own childhood to become queen 
      of the world.</description>
   </book>
</catalog>

The output:


<genres>
<genre name=”Horror” average-price=”19.2”>
  <title>Creepy Crawlies</title>
  <title>...</title>
 </genre>
 <genre name=”Science Fiction” average-price=”32.1”>
  <title>...</title>
 <title>...</title>
 </genre>
 …
</genres>
