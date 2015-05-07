create table if not exists evt_evenementen
(
  id     number PRIMARY KEY NOT NULL,
  naam   varchar2 (100),
  uit_id number

);

create table if not exists evt_genodigden
(
  id           number PRIMARY KEY NOT NULL,
  emailadres   varchar2 (100)
);


create table if not exists evt_uitnodigingen
(
id number PRIMARY KEY NOT NULL,
beschrijving varchar2(100),
gen_id number
);