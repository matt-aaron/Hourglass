--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6 (Ubuntu 10.6-0ubuntu0.18.10.1)
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: operators; Type: TABLE; Schema: public; Owner: api
--

CREATE TABLE public.operators (
    id integer NOT NULL,
    name integer NOT NULL
);


ALTER TABLE public.operators OWNER TO api;

--
-- Name: operators_id_seq; Type: SEQUENCE; Schema: public; Owner: api
--

CREATE SEQUENCE public.operators_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.operators_id_seq OWNER TO api;

--
-- Name: operators_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: api
--

ALTER SEQUENCE public.operators_id_seq OWNED BY public.operators.id;


--
-- Name: park_schedules; Type: TABLE; Schema: public; Owner: api
--

CREATE TABLE public.park_schedules (
    id integer NOT NULL,
    park_id integer NOT NULL,
    is_open boolean DEFAULT false NOT NULL,
    start timestamp without time zone NOT NULL,
    "end" timestamp without time zone NOT NULL
);


ALTER TABLE public.park_schedules OWNER TO api;

--
-- Name: park_schedules_id_seq; Type: SEQUENCE; Schema: public; Owner: api
--

CREATE SEQUENCE public.park_schedules_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.park_schedules_id_seq OWNER TO api;

--
-- Name: park_schedules_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: api
--

ALTER SEQUENCE public.park_schedules_id_seq OWNED BY public.park_schedules.id;


--
-- Name: parks; Type: TABLE; Schema: public; Owner: api
--

CREATE TABLE public.parks (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    operator_id integer NOT NULL
);


ALTER TABLE public.parks OWNER TO api;

--
-- Name: parks_id_seq; Type: SEQUENCE; Schema: public; Owner: api
--

CREATE SEQUENCE public.parks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parks_id_seq OWNER TO api;

--
-- Name: parks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: api
--

ALTER SEQUENCE public.parks_id_seq OWNED BY public.parks.id;


--
-- Name: ride_statuses; Type: TABLE; Schema: public; Owner: api
--

CREATE TABLE public.ride_statuses (
    id integer NOT NULL,
    ride_id integer NOT NULL,
    is_open boolean DEFAULT false NOT NULL,
    wait_time integer DEFAULT 0 NOT NULL,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.ride_statuses OWNER TO api;

--
-- Name: ride_statuses_id_seq; Type: SEQUENCE; Schema: public; Owner: api
--

CREATE SEQUENCE public.ride_statuses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ride_statuses_id_seq OWNER TO api;

--
-- Name: ride_statuses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: api
--

ALTER SEQUENCE public.ride_statuses_id_seq OWNED BY public.ride_statuses.id;


--
-- Name: ride_types; Type: TABLE; Schema: public; Owner: api
--

CREATE TABLE public.ride_types (
    id integer NOT NULL,
    park_id integer NOT NULL,
    platform_id character varying(36) NOT NULL,
    name character varying(50)
);


ALTER TABLE public.ride_types OWNER TO api;

--
-- Name: ride_types_id_seq; Type: SEQUENCE; Schema: public; Owner: api
--

CREATE SEQUENCE public.ride_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ride_types_id_seq OWNER TO api;

--
-- Name: ride_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: api
--

ALTER SEQUENCE public.ride_types_id_seq OWNED BY public.ride_types.id;


--
-- Name: rides; Type: TABLE; Schema: public; Owner: api
--

CREATE TABLE public.rides (
    id integer NOT NULL,
    park_id integer NOT NULL,
    platform_id character varying(36) NOT NULL,
    ride_type_id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.rides OWNER TO api;

--
-- Name: rides_id_seq; Type: SEQUENCE; Schema: public; Owner: api
--

CREATE SEQUENCE public.rides_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rides_id_seq OWNER TO api;

--
-- Name: rides_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: api
--

ALTER SEQUENCE public.rides_id_seq OWNED BY public.rides.id;


--
-- Name: operators id; Type: DEFAULT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.operators ALTER COLUMN id SET DEFAULT nextval('public.operators_id_seq'::regclass);


--
-- Name: park_schedules id; Type: DEFAULT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.park_schedules ALTER COLUMN id SET DEFAULT nextval('public.park_schedules_id_seq'::regclass);


--
-- Name: parks id; Type: DEFAULT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.parks ALTER COLUMN id SET DEFAULT nextval('public.parks_id_seq'::regclass);


--
-- Name: ride_statuses id; Type: DEFAULT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.ride_statuses ALTER COLUMN id SET DEFAULT nextval('public.ride_statuses_id_seq'::regclass);


--
-- Name: ride_types id; Type: DEFAULT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.ride_types ALTER COLUMN id SET DEFAULT nextval('public.ride_types_id_seq'::regclass);


--
-- Name: rides id; Type: DEFAULT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.rides ALTER COLUMN id SET DEFAULT nextval('public.rides_id_seq'::regclass);


--
-- Data for Name: operators; Type: TABLE DATA; Schema: public; Owner: api
--

COPY public.operators (id, name) FROM stdin;
\.


--
-- Data for Name: park_schedules; Type: TABLE DATA; Schema: public; Owner: api
--

COPY public.park_schedules (id, park_id, is_open, start, "end") FROM stdin;
\.


--
-- Data for Name: parks; Type: TABLE DATA; Schema: public; Owner: api
--

COPY public.parks (id, name, operator_id) FROM stdin;
\.


--
-- Data for Name: ride_statuses; Type: TABLE DATA; Schema: public; Owner: api
--

COPY public.ride_statuses (id, ride_id, is_open, wait_time, updated_at, created_at) FROM stdin;
\.


--
-- Data for Name: ride_types; Type: TABLE DATA; Schema: public; Owner: api
--

COPY public.ride_types (id, park_id, platform_id, name) FROM stdin;
\.


--
-- Data for Name: rides; Type: TABLE DATA; Schema: public; Owner: api
--

COPY public.rides (id, park_id, platform_id, ride_type_id, name) FROM stdin;
\.


--
-- Name: operators_id_seq; Type: SEQUENCE SET; Schema: public; Owner: api
--

SELECT pg_catalog.setval('public.operators_id_seq', 1, false);


--
-- Name: park_schedules_id_seq; Type: SEQUENCE SET; Schema: public; Owner: api
--

SELECT pg_catalog.setval('public.park_schedules_id_seq', 1, false);


--
-- Name: parks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: api
--

SELECT pg_catalog.setval('public.parks_id_seq', 1, false);


--
-- Name: ride_statuses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: api
--

SELECT pg_catalog.setval('public.ride_statuses_id_seq', 1, false);


--
-- Name: ride_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: api
--

SELECT pg_catalog.setval('public.ride_types_id_seq', 1, false);


--
-- Name: rides_id_seq; Type: SEQUENCE SET; Schema: public; Owner: api
--

SELECT pg_catalog.setval('public.rides_id_seq', 1, false);


--
-- Name: operators operators_pk; Type: CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.operators
    ADD CONSTRAINT operators_pk PRIMARY KEY (id);


--
-- Name: park_schedules park_schedules_pk; Type: CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.park_schedules
    ADD CONSTRAINT park_schedules_pk PRIMARY KEY (id);


--
-- Name: parks parks_pk; Type: CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.parks
    ADD CONSTRAINT parks_pk PRIMARY KEY (id);


--
-- Name: ride_statuses ride_statuses_pk; Type: CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.ride_statuses
    ADD CONSTRAINT ride_statuses_pk PRIMARY KEY (id);


--
-- Name: ride_types ride_types_pk; Type: CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.ride_types
    ADD CONSTRAINT ride_types_pk PRIMARY KEY (id);


--
-- Name: rides rides_pk; Type: CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.rides
    ADD CONSTRAINT rides_pk PRIMARY KEY (id);


--
-- Name: operators_name_uindex; Type: INDEX; Schema: public; Owner: api
--

CREATE UNIQUE INDEX operators_name_uindex ON public.operators USING btree (name);


--
-- Name: park_schedules park_schedules_parks_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.park_schedules
    ADD CONSTRAINT park_schedules_parks_id_fk FOREIGN KEY (park_id) REFERENCES public.parks(id);


--
-- Name: parks parks_operators_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.parks
    ADD CONSTRAINT parks_operators_id_fk FOREIGN KEY (operator_id) REFERENCES public.operators(id);


--
-- Name: ride_statuses ride_statuses_rides_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.ride_statuses
    ADD CONSTRAINT ride_statuses_rides_id_fk FOREIGN KEY (ride_id) REFERENCES public.rides(id);


--
-- Name: ride_types ride_types_parks_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.ride_types
    ADD CONSTRAINT ride_types_parks_id_fk FOREIGN KEY (park_id) REFERENCES public.parks(id);


--
-- Name: rides rides_parks_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.rides
    ADD CONSTRAINT rides_parks_id_fk FOREIGN KEY (park_id) REFERENCES public.parks(id);


--
-- Name: rides rides_ride_types_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: api
--

ALTER TABLE ONLY public.rides
    ADD CONSTRAINT rides_ride_types_id_fk FOREIGN KEY (ride_type_id) REFERENCES public.ride_types(id);


--
-- PostgreSQL database dump complete
--

