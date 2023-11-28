--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-11-28 16:45:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16938)
-- Name: common_problems; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.common_problems (
    problem_code bigint NOT NULL,
    problem_description text
);


--
-- TOC entry 216 (class 1259 OID 16943)
-- Name: common_problems_problem_code_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.common_problems_problem_code_seq
    START WITH 11500
    INCREMENT BY 1
    MINVALUE 11500
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4921 (class 0 OID 0)
-- Dependencies: 216
-- Name: common_problems_problem_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.common_problems_problem_code_seq OWNED BY public.common_problems.problem_code;


--
-- TOC entry 217 (class 1259 OID 17038)
-- Name: dog_problems; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.dog_problems (
    problem_code bigint NOT NULL,
    date_of_problem date NOT NULL,
    health_record_id bigint,
    treatment character varying(255),
    other_details text
);


--
-- TOC entry 218 (class 1259 OID 17043)
-- Name: dogs; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.dogs (
    dog_id bigint NOT NULL,
    born_in_litter_id bigint,
    dogs_name character varying(255),
    gender_mf character(1),
    date_of_birth date,
    place_of_birth character varying(255),
    other_details text,
    adopted boolean DEFAULT false,
    owner character varying(64) DEFAULT 'no owner'::character varying NOT NULL,
    CONSTRAINT gender_check CHECK ((gender_mf = ANY (ARRAY['M'::bpchar, 'F'::bpchar])))
);


--
-- TOC entry 219 (class 1259 OID 17049)
-- Name: dogs_dog_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.dogs_dog_id_seq
    START WITH 87400
    INCREMENT BY 1
    MINVALUE 87400
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4922 (class 0 OID 0)
-- Dependencies: 219
-- Name: dogs_dog_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.dogs_dog_id_seq OWNED BY public.dogs.dog_id;


--
-- TOC entry 220 (class 1259 OID 17050)
-- Name: health_records; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.health_records (
    health_record_id bigint NOT NULL,
    dog_id bigint,
    vet_id bigint,
    summary text,
    details text
);


--
-- TOC entry 221 (class 1259 OID 17055)
-- Name: health_records_health_record_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.health_records_health_record_id_seq
    START WITH 14800
    INCREMENT BY 1
    MINVALUE 14800
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4923 (class 0 OID 0)
-- Dependencies: 221
-- Name: health_records_health_record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.health_records_health_record_id_seq OWNED BY public.health_records.health_record_id;


--
-- TOC entry 222 (class 1259 OID 17056)
-- Name: litters; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.litters (
    litter_id bigint NOT NULL,
    litter_sire_dog_id bigint,
    litter_dam_dog_id bigint,
    date_of_birth_of_litter date,
    place_of_birth_of_litter character varying(255),
    other_details text
);


--
-- TOC entry 223 (class 1259 OID 17061)
-- Name: litters_litter_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.litters_litter_id_seq
    START WITH 33900
    INCREMENT BY 1
    MINVALUE 33900
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4924 (class 0 OID 0)
-- Dependencies: 223
-- Name: litters_litter_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.litters_litter_id_seq OWNED BY public.litters.litter_id;


--
-- TOC entry 224 (class 1259 OID 17062)
-- Name: relationship_types; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.relationship_types (
    relationship_code bigint NOT NULL,
    relationship_description character varying(255)
);


--
-- TOC entry 225 (class 1259 OID 17065)
-- Name: relationship_types_relationship_code_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.relationship_types_relationship_code_seq
    START WITH 33300
    INCREMENT BY 1
    MINVALUE 33300
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4925 (class 0 OID 0)
-- Dependencies: 225
-- Name: relationship_types_relationship_code_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.relationship_types_relationship_code_seq OWNED BY public.relationship_types.relationship_code;


--
-- TOC entry 226 (class 1259 OID 17066)
-- Name: relationships; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.relationships (
    relationship_id bigint NOT NULL,
    dog_1_id bigint,
    dog_2_id bigint,
    relationship_code bigint,
    other_details text
);


--
-- TOC entry 227 (class 1259 OID 17071)
-- Name: relationships_relationship_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.relationships_relationship_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4926 (class 0 OID 0)
-- Dependencies: 227
-- Name: relationships_relationship_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.relationships_relationship_id_seq OWNED BY public.relationships.relationship_id;


--
-- TOC entry 228 (class 1259 OID 17072)
-- Name: vets; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.vets (
    vet_id bigint NOT NULL,
    vet_name character varying(255),
    other_details text
);


--
-- TOC entry 229 (class 1259 OID 17077)
-- Name: vets_vet_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.vets_vet_id_seq
    START WITH 92000
    INCREMENT BY 1
    MINVALUE 92000
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4927 (class 0 OID 0)
-- Dependencies: 229
-- Name: vets_vet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.vets_vet_id_seq OWNED BY public.vets.vet_id;


--
-- TOC entry 4722 (class 2604 OID 17078)
-- Name: common_problems problem_code; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.common_problems ALTER COLUMN problem_code SET DEFAULT nextval('public.common_problems_problem_code_seq'::regclass);


--
-- TOC entry 4723 (class 2604 OID 17079)
-- Name: dogs dog_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dogs ALTER COLUMN dog_id SET DEFAULT nextval('public.dogs_dog_id_seq'::regclass);


--
-- TOC entry 4726 (class 2604 OID 17080)
-- Name: health_records health_record_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.health_records ALTER COLUMN health_record_id SET DEFAULT nextval('public.health_records_health_record_id_seq'::regclass);


--
-- TOC entry 4727 (class 2604 OID 17081)
-- Name: litters litter_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.litters ALTER COLUMN litter_id SET DEFAULT nextval('public.litters_litter_id_seq'::regclass);


--
-- TOC entry 4728 (class 2604 OID 17082)
-- Name: relationship_types relationship_code; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationship_types ALTER COLUMN relationship_code SET DEFAULT nextval('public.relationship_types_relationship_code_seq'::regclass);


--
-- TOC entry 4729 (class 2604 OID 17083)
-- Name: relationships relationship_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationships ALTER COLUMN relationship_id SET DEFAULT nextval('public.relationships_relationship_id_seq'::regclass);


--
-- TOC entry 4730 (class 2604 OID 17084)
-- Name: vets vet_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.vets ALTER COLUMN vet_id SET DEFAULT nextval('public.vets_vet_id_seq'::regclass);


--
-- TOC entry 4901 (class 0 OID 16938)
-- Dependencies: 215
-- Data for Name: common_problems; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.common_problems VALUES (11580, 'Fleas');
INSERT INTO public.common_problems VALUES (11577, 'Worms');
INSERT INTO public.common_problems VALUES (11592, 'Colitis');
INSERT INTO public.common_problems VALUES (11584, 'Allergy');
INSERT INTO public.common_problems VALUES (11563, 'Anxiety');


--
-- TOC entry 4903 (class 0 OID 17038)
-- Dependencies: 217
-- Data for Name: dog_problems; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.dog_problems VALUES (11580, '2022-09-30', 14811, 'Pablo was given medicine to get rid of his fleas and itching.', 'Pablo had fleas all over his body.');
INSERT INTO public.dog_problems VALUES (11563, '2023-10-21', 14814, 'Advised owner to take Mochi on walks at least once a day.', 'Mochi was very anxious and wouldnt stop trembling and crying.');
INSERT INTO public.dog_problems VALUES (11584, '2023-02-02', 14816, 'Administered antihistamine', 'After administering Bambi with her Parvo vaccine, she presented an allergic reaction with inflammation on her face and paws.');
INSERT INTO public.dog_problems VALUES (11584, '2023-09-02', 14809, 'Ranitidine 3 times a day for a week', 'Coco ate something off the ground that irritated her stomach and vomited during a day.');


--
-- TOC entry 4904 (class 0 OID 17043)
-- Dependencies: 218
-- Data for Name: dogs; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.dogs VALUES (87421, NULL, 'María Teresa', 'F', '2018-12-12', 'El Paso', 'Australian shepherd. Left eye is brown, right one is blue. Black with white. Very lovely.', false, 'no owner');
INSERT INTO public.dogs VALUES (87412, NULL, 'Hermenegildo', 'M', '2015-04-07', 'San Francisco', 'Golden Retriever. Honey colored fur. Family friendly, but naughty.', false, 'no owner');
INSERT INTO public.dogs VALUES (87423, NULL, 'Gertrudis', 'F', '2021-08-17', 'Sacramento', 'Golden Retriever. Honey colored fur. Very healthy, but a picky eater.', false, 'no owner');
INSERT INTO public.dogs VALUES (87482, 33910, 'Ulises', 'M', '2023-05-25', 'Anaheim', 'Golden Retriever. Honey colored fur. Very cute and playful. Lives for biting others.', false, 'no owner');
INSERT INTO public.dogs VALUES (87456, NULL, 'Pablo', 'M', '2018-06-18', 'Aurora', 'Dalmatian. Predominantly white coat with scattered black spots. Bold personality, a good boy nonetheless.', false, 'no owner');
INSERT INTO public.dogs VALUES (87434, NULL, 'Canela', 'F', '2020-09-08', 'Aspen', 'Dalmatian. Has a heart shaped spot on her left eye. Very gentle.', false, 'no owner');
INSERT INTO public.dogs VALUES (87486, 33911, 'Nala', 'F', '2023-02-16', 'Denver', 'Dalmatian. White coat, doesnt have any spots yet. Shy, but playful.', false, 'no owner');
INSERT INTO public.dogs VALUES (87488, 33911, 'Gigi', 'F', '2023-02-16', 'Denver', 'Dalmatian. White coat with brown spots. Very cute and playful.', false, 'no owner');
INSERT INTO public.dogs VALUES (87481, 33909, 'Luna', 'F', '2020-10-10', 'Houston', 'Australian shepherd. Light blue eyes. Mostly white with some black and reddish brown spots. Very cute.', false, 'no owner');
INSERT INTO public.dogs VALUES (87480, 33909, 'Milo', 'M', '2020-10-10', 'Houston', 'Australian shepherd. Dark brown eyes. Black and white with reddish brown spots on his beautiful face.', false, 'no owner');
INSERT INTO public.dogs VALUES (87417, NULL, 'Oliver', 'M', '2019-04-15', 'Dallas', 'Australian shepherd. Brown eyes. Chocolate brown with white. Very playful and handsome.', false, 'no owner');
INSERT INTO public.dogs VALUES (87483, 33910, 'Leo', 'M', '2023-05-25', 'Anaheim', 'Golden Retriever. Honey colored fur. Kinda dumb, but has a big heart.', false, 'no owner');
INSERT INTO public.dogs VALUES (87484, 33910, 'Coco', 'F', '2023-05-25', 'Anaheim', 'Golden Retriever. Honey colored fur. Her crossed eyes are what give her her charm.', false, 'no owner');
INSERT INTO public.dogs VALUES (87485, 33910, 'Louie', 'F', '2023-05-25', 'Anaheim', 'Golden Retriever. Honey colored fur. Very adventurous, always protects her siblings.', false, 'no owner');
INSERT INTO public.dogs VALUES (87487, 33911, 'Mochi', 'F', '2023-02-16', 'Denver', 'Dalmatian. White coat with black spots. Her right ear is completely white, and the right one white.', false, 'no owner');
INSERT INTO public.dogs VALUES (87489, 33911, 'Bambi', 'F', '2023-02-16', 'Denver', 'Dalmatian. White coat with black spots. Has a heart shaped spot on her nose. Smallest one in the litter.', false, 'no owner');


--
-- TOC entry 4906 (class 0 OID 17050)
-- Dependencies: 220
-- Data for Name: health_records; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.health_records VALUES (14801, 87417, 92003, 'All vaccines have been administered. Next boost for rabies should be on June 2024.', 'Oliver is very healthy overall.');
INSERT INTO public.health_records VALUES (14802, 87421, 92002, 'All vaccines have been administered. Next boost for rabies should be in April 2024.', 'María Teresa has always been healthy.');
INSERT INTO public.health_records VALUES (14803, 87480, 92001, 'All vaccines have been administered. Next boost for rabies should be in May 2024.', 'Milo is very healthy.');
INSERT INTO public.health_records VALUES (14804, 87481, 92003, 'All vaccines have been administered. Next boost for parvo should be in 3 months.', 'Luna is very healthy.');
INSERT INTO public.health_records VALUES (14805, 87412, 92002, 'All vaccines have been administered. Next boost for distemper should be on December 2023.', 'Hermenegildo was sickish as a puppy, but is very healthy now.');
INSERT INTO public.health_records VALUES (14806, 87423, 92002, 'All vaccines have been administered. Next boost for rabies should be in April 2024.', 'Gertrudis has always been strong and healthy despite being a picky eater.');
INSERT INTO public.health_records VALUES (14807, 87482, 92002, 'Parvo and distemper vaccines have already been administered. Rabies shot should be in August 2023.', 'Ulises is very healthy.');
INSERT INTO public.health_records VALUES (14808, 87483, 92003, 'Parvo and distemper vaccines have already been administered. Rabies shot should be in August 2023.', 'Leo is very healthy.');
INSERT INTO public.health_records VALUES (14809, 87484, 92001, 'Parvo and distemper vaccines have already been administered. Rabies shot should be in August 2023.', 'Coco is very healthy. She occasionally crosses her eyes, but she seems to be able to see just fine.');
INSERT INTO public.health_records VALUES (14810, 87485, 92003, 'Parvo and distemper vaccines have already been administered. Rabies shot should be in August 2023.', 'Allergic to peanuts. Louie is very healthy.');
INSERT INTO public.health_records VALUES (14811, 87456, 92001, 'All vaccines have been administered. Next boost for distemper should be on January 2024.', 'Pablo is healthy overall.');
INSERT INTO public.health_records VALUES (14812, 87434, 92002, 'All vaccines have been administered. Next boost for rabies should be in March 2024.', 'Canela is healthy, but has colitis every now and then due to her anxiety.');
INSERT INTO public.health_records VALUES (14813, 87486, 92003, 'Parvo vaccine has already been administered. Needs to be dewormed. Distemper shot should be in November 2023.', 'Nala is very healthy.');
INSERT INTO public.health_records VALUES (14814, 87487, 92001, 'Parvo vaccine has already been administered. Needs to be dewormed. Distemper shot should be in November 2023.', 'Mochi is very healthy, but has shown signs of separation anxiety.');
INSERT INTO public.health_records VALUES (14815, 87488, 92001, 'Parvo vaccine has already been administered. Needs to be dewormed. Distemper shot should be in November 2023.', 'Gigi is very healthy.');
INSERT INTO public.health_records VALUES (14816, 87489, 92003, 'Parvo vaccine has already been administered. Needs to be dewormed. Distemper shot should be in November 2023.', 'Allergic to something in vaccines. Should always administer an antihistamine after a vaccine. Bambi is very healthy.');


--
-- TOC entry 4908 (class 0 OID 17056)
-- Dependencies: 222
-- Data for Name: litters; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.litters VALUES (33909, 87417, 87421, '2020-10-10', 'Houston', 'Australian shepherds. Two puppies in total. All healthy.');
INSERT INTO public.litters VALUES (33910, 87412, 87423, '2023-05-25', 'Anaheim', 'Golden Retrievers. Four puppies in total. All healthy.');
INSERT INTO public.litters VALUES (33911, 87456, 87434, '2023-02-16', 'Denver', 'Dalmatians. Four puppies in total. All healthy.');
INSERT INTO public.litters VALUES (33900, NULL, NULL, NULL, NULL, 'The dog was not born into a litter, it was gifted or rescued from the street');


--
-- TOC entry 4910 (class 0 OID 17062)
-- Dependencies: 224
-- Data for Name: relationship_types; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.relationship_types VALUES (33301, 'Parent');
INSERT INTO public.relationship_types VALUES (33302, 'Child');
INSERT INTO public.relationship_types VALUES (33303, 'Siblings');
INSERT INTO public.relationship_types VALUES (33304, 'Couple');
INSERT INTO public.relationship_types VALUES (33305, 'Ex-couple');


--
-- TOC entry 4912 (class 0 OID 17066)
-- Dependencies: 226
-- Data for Name: relationships; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.relationships VALUES (1, 87417, 87421, 33304, 'The dogs are a couple, and have been happily married for one year.');
INSERT INTO public.relationships VALUES (2, 87417, 87480, 33301, 'Oliver is Milos father.');
INSERT INTO public.relationships VALUES (3, 87417, 87481, 33301, 'Oliver is Lunas father.');
INSERT INTO public.relationships VALUES (4, 87421, 87480, 33301, 'María Teresa is Milos mother.');
INSERT INTO public.relationships VALUES (5, 87421, 87481, 33301, 'María Teresa is Lunas mother.');
INSERT INTO public.relationships VALUES (6, 87480, 87481, 33303, 'Milo and Luna are siblings.');
INSERT INTO public.relationships VALUES (7, 87412, 87423, 33304, 'The dogs are a couple, and are very much in love.');
INSERT INTO public.relationships VALUES (8, 87412, 87482, 33301, 'Hermenegildo is Ulises father.');
INSERT INTO public.relationships VALUES (9, 87412, 87483, 33301, 'Hermenegildo is Leos father.');
INSERT INTO public.relationships VALUES (10, 87412, 87484, 33301, 'Hermenegildo is Cocos father.');
INSERT INTO public.relationships VALUES (11, 87412, 87485, 33301, 'Hermenegildo is Louies father.');
INSERT INTO public.relationships VALUES (12, 87423, 87482, 33301, 'Gertrudis is Ulises mother.');
INSERT INTO public.relationships VALUES (13, 87423, 87483, 33301, 'Gertrudis is Leos mother.');
INSERT INTO public.relationships VALUES (14, 87423, 87484, 33301, 'Gertrudis is Cocos mother.');
INSERT INTO public.relationships VALUES (15, 87423, 87485, 33301, 'Gertrudis is Louies mother.');
INSERT INTO public.relationships VALUES (16, 87482, 87483, 33303, 'Ulises and Leo are siblings.');
INSERT INTO public.relationships VALUES (17, 87482, 87484, 33303, 'Ulises and Coco are siblings.');
INSERT INTO public.relationships VALUES (18, 87482, 87485, 33303, 'Ulises and Louie are siblings.');
INSERT INTO public.relationships VALUES (19, 87483, 87484, 33303, 'Leo and Coco are siblings.');
INSERT INTO public.relationships VALUES (20, 87483, 87485, 33303, 'Leo and Louie are siblings.');
INSERT INTO public.relationships VALUES (21, 87484, 87485, 33303, 'Coco and Louie are siblings.');
INSERT INTO public.relationships VALUES (22, 87456, 87434, 33305, 'The dogs were a couple, but are now divorced.');
INSERT INTO public.relationships VALUES (23, 87456, 87486, 33301, 'Pablo is Nalas father.');
INSERT INTO public.relationships VALUES (24, 87456, 87487, 33301, 'Pablo is Mochis father.');
INSERT INTO public.relationships VALUES (25, 87456, 87488, 33301, 'Pablo is Gigis father.');
INSERT INTO public.relationships VALUES (26, 87456, 87489, 33301, 'Pablo is Bambis father.');
INSERT INTO public.relationships VALUES (27, 87434, 87486, 33301, 'Canela is Nalas father.');
INSERT INTO public.relationships VALUES (28, 87434, 87487, 33301, 'Canela is Mochis father.');
INSERT INTO public.relationships VALUES (29, 87434, 87488, 33301, 'Canela is Gigis father.');
INSERT INTO public.relationships VALUES (30, 87434, 87489, 33301, 'Canela is Bambis father.');
INSERT INTO public.relationships VALUES (31, 87486, 87487, 33303, 'Nala and Mochi are siblings.');
INSERT INTO public.relationships VALUES (32, 87486, 87488, 33303, 'Nala and Gigi are siblings.');
INSERT INTO public.relationships VALUES (33, 87486, 87489, 33303, 'Nala and Bambi are siblings.');
INSERT INTO public.relationships VALUES (34, 87487, 87488, 33303, 'Mochi and Gigi are siblings.');
INSERT INTO public.relationships VALUES (35, 87487, 87489, 33303, 'Mochi and Bambi are siblings.');
INSERT INTO public.relationships VALUES (36, 87488, 87489, 33303, 'Gigi and Bambi are siblings.');


--
-- TOC entry 4914 (class 0 OID 17072)
-- Dependencies: 228
-- Data for Name: vets; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.vets VALUES (92001, 'Ángel Francisco Pérez Ibarra', 'Morning turn. Specializes in nutrition.');
INSERT INTO public.vets VALUES (92002, 'Miguel Angel Arroyo López', 'Afternoon turn. Specializes in surgery.');
INSERT INTO public.vets VALUES (92003, 'Verónica Rodríguez Navarro', 'Night turn. Specializes in x-rays and ultrasounds.');


--
-- TOC entry 4928 (class 0 OID 0)
-- Dependencies: 216
-- Name: common_problems_problem_code_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.common_problems_problem_code_seq', 11501, false);


--
-- TOC entry 4929 (class 0 OID 0)
-- Dependencies: 219
-- Name: dogs_dog_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.dogs_dog_id_seq', 87401, false);


--
-- TOC entry 4930 (class 0 OID 0)
-- Dependencies: 221
-- Name: health_records_health_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.health_records_health_record_id_seq', 14800, false);


--
-- TOC entry 4931 (class 0 OID 0)
-- Dependencies: 223
-- Name: litters_litter_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.litters_litter_id_seq', 33901, false);


--
-- TOC entry 4932 (class 0 OID 0)
-- Dependencies: 225
-- Name: relationship_types_relationship_code_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.relationship_types_relationship_code_seq', 33300, false);


--
-- TOC entry 4933 (class 0 OID 0)
-- Dependencies: 227
-- Name: relationships_relationship_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.relationships_relationship_id_seq', 1, false);


--
-- TOC entry 4934 (class 0 OID 0)
-- Dependencies: 229
-- Name: vets_vet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.vets_vet_id_seq', 92000, false);


--
-- TOC entry 4733 (class 2606 OID 17086)
-- Name: common_problems common_problems_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.common_problems
    ADD CONSTRAINT common_problems_pkey PRIMARY KEY (problem_code);


--
-- TOC entry 4735 (class 2606 OID 17088)
-- Name: dog_problems dog_problems_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dog_problems
    ADD CONSTRAINT dog_problems_pkey PRIMARY KEY (problem_code, date_of_problem);


--
-- TOC entry 4737 (class 2606 OID 17090)
-- Name: dogs dogs_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dogs
    ADD CONSTRAINT dogs_pkey PRIMARY KEY (dog_id);


--
-- TOC entry 4739 (class 2606 OID 17092)
-- Name: health_records health_records_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.health_records
    ADD CONSTRAINT health_records_pkey PRIMARY KEY (health_record_id);


--
-- TOC entry 4741 (class 2606 OID 17094)
-- Name: litters litters_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.litters
    ADD CONSTRAINT litters_pkey PRIMARY KEY (litter_id);


--
-- TOC entry 4743 (class 2606 OID 17096)
-- Name: relationship_types relationship_types_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationship_types
    ADD CONSTRAINT relationship_types_pkey PRIMARY KEY (relationship_code);


--
-- TOC entry 4745 (class 2606 OID 17098)
-- Name: relationships relationships_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationships
    ADD CONSTRAINT relationships_pkey PRIMARY KEY (relationship_id);


--
-- TOC entry 4747 (class 2606 OID 17100)
-- Name: vets vets_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.vets
    ADD CONSTRAINT vets_pkey PRIMARY KEY (vet_id);


--
-- TOC entry 4748 (class 2606 OID 17101)
-- Name: dog_problems dog_problems_health_record_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dog_problems
    ADD CONSTRAINT dog_problems_health_record_id_fkey FOREIGN KEY (health_record_id) REFERENCES public.health_records(health_record_id);


--
-- TOC entry 4749 (class 2606 OID 17106)
-- Name: dog_problems dog_problems_problem_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dog_problems
    ADD CONSTRAINT dog_problems_problem_code_fkey FOREIGN KEY (problem_code) REFERENCES public.common_problems(problem_code);


--
-- TOC entry 4750 (class 2606 OID 17111)
-- Name: dogs dogs_born_in_litter_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.dogs
    ADD CONSTRAINT dogs_born_in_litter_id_fkey FOREIGN KEY (born_in_litter_id) REFERENCES public.litters(litter_id);


--
-- TOC entry 4751 (class 2606 OID 17116)
-- Name: health_records health_records_dog_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.health_records
    ADD CONSTRAINT health_records_dog_id_fkey FOREIGN KEY (dog_id) REFERENCES public.dogs(dog_id);


--
-- TOC entry 4752 (class 2606 OID 17121)
-- Name: health_records health_records_vet_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.health_records
    ADD CONSTRAINT health_records_vet_id_fkey FOREIGN KEY (vet_id) REFERENCES public.vets(vet_id);


--
-- TOC entry 4753 (class 2606 OID 17126)
-- Name: litters litter_dam_dog_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.litters
    ADD CONSTRAINT litter_dam_dog_id_fkey FOREIGN KEY (litter_dam_dog_id) REFERENCES public.dogs(dog_id);


--
-- TOC entry 4754 (class 2606 OID 17131)
-- Name: litters litter_sire_dog_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.litters
    ADD CONSTRAINT litter_sire_dog_id_fkey FOREIGN KEY (litter_sire_dog_id) REFERENCES public.dogs(dog_id);


--
-- TOC entry 4755 (class 2606 OID 17136)
-- Name: relationships relationships_dog_1_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationships
    ADD CONSTRAINT relationships_dog_1_id_fkey FOREIGN KEY (dog_1_id) REFERENCES public.dogs(dog_id);


--
-- TOC entry 4756 (class 2606 OID 17141)
-- Name: relationships relationships_dog_2_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationships
    ADD CONSTRAINT relationships_dog_2_id_fkey FOREIGN KEY (dog_2_id) REFERENCES public.dogs(dog_id);


--
-- TOC entry 4757 (class 2606 OID 17146)
-- Name: relationships relationships_relationship_code_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.relationships
    ADD CONSTRAINT relationships_relationship_code_fkey FOREIGN KEY (relationship_code) REFERENCES public.relationship_types(relationship_code);


-- Completed on 2023-11-28 16:45:34

--
-- PostgreSQL database dump complete
--

