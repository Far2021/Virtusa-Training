import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function Book() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[name,setName]=useState('')
    const[author,setAuthor]=useState('')
    const[books,setBooks]=useState([])
     const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const book={name,author}
    console.log(book)
    fetch("http://localhost:7071/book/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(book)

  }).then(()=>{
    console.log("New Book added")
  })
}

useEffect(()=>{
  fetch("http://localhost:7071/book/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setBooks(result);
  }
)
},[])
  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Add Book</u></h1>

    <form className={classes.root} noValidate autoComplete="off">
    
      <TextField id="outlined-basic" label="Book Name" variant="outlined" fullWidth 
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Book Author" variant="outlined" fullWidth
      value={author}
      onChange={(e)=>setAuthor(e.target.value)}
      />
      <Button variant="contained" color="secondary" onClick={handleClick}>
  Submit
</Button>
    </form>
   
    </Paper>
    <h1>Books</h1>

    <Paper elevation={3} style={paperStyle}>

      {books.map(book=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={book.id}>
         Id:{book.id}<br/>
         Name:{book.name}<br/>
         Author:{book.author}

        </Paper>
      ))
}


    </Paper>



    </Container>
  );
}