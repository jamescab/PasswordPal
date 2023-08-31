const express = require('express');
const morgan = require('morgan');
const mongoose = require('mongoose');
const { render } = require('ejs');
const Card = require('./models/card');

/*
TODO:
- Add randomly generated password
- Find by app name
- Styling
*/

//express app
const app = express();

//connect to mongodb (NEVER LEAVE SIGN IN INFO IN CODE WHEN UR DONE)  
const dbURI = 'mongodb+srv://<Username>:<Password>@ppcluster.rgt9i9i.mongodb.net/<CollectionName>?retryWrites=true&w=majority';
mongoose.connect(dbURI, {useNewUrlParser: true, useUnifiedTopology: true})
    .then((result) => app.listen(3000))
    .catch((err) => console.log(err));
//Register view engine
app.set('view engine', 'ejs');

//middleware and static files
app.use(express.static('public'));
app.use(express.urlencoded({extended: true}));
app.use(morgan('dev'));
app.use((req, res, next) => {
    res.locals.path = req.path;
    next();
  });

//ROUTES
app.get('/', (req, res) => {
    res.render('index', {title: 'Home'});
  });
  
app.get('/add', (req, res) => {
    res.render('add', { title: 'Add' });
});

app.get('/find', (req, res) => {
    res.render('find', { title: 'Find' });
});

app.get('/wallet', (req, res) => {
    Card.find().collation({locale:'en',strength: 2}).sort({app:1})
        .then((result) => {   
        res.render('wallet', { title: 'Wallet', cards: result});
        }).catch((err) => {
            console.log(err);
        })
});

app.get('/wallet/:id', (req, res) => {
    const id = req.params.id;
    Card.findById(id)
      .then(result => {
        res.render('details', { card: result, title: 'Card Details' });
      })
      .catch(err => {
        console.log(err);
      });
  });

app.delete('/wallet/:id', (req, res) => {
   const id = req.params.id;
   
   Card.findByIdAndDelete(id)
     .then(result => {
       res.json({ redirect: '/wallet' });
     })
     .catch(err => {
       console.log(err);
     });
 });

//POST HANDLER
app.post('/wallet', (req, res) => {
    const card = new Card(req.body);
    console.log(req.body);
    card.save()
        .then((result) => {
            res.redirect('/wallet');
        }).catch((err) => {
            console.log(err);
        })
});
  
// 404 page
app.use((req, res) => {
    res.status(404).render('404', { title: '404' });
});